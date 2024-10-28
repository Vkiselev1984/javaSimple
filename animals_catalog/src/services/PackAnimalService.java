package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseConnection;
import model.PackAnimal;
import view.ConsoleView;

public class PackAnimalService {

    private final DatabaseConnection dbConnection;
    private final ConsoleView view;

    public PackAnimalService(DatabaseConnection dbConnection, ConsoleView view) {
        this.dbConnection = dbConnection;
        this.view = view;
        createSchemaIfNotExists();
    }

    private void createSchemaIfNotExists() {
        String sql = "CREATE SCHEMA IF NOT EXISTS public";
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            view.displayMessage("Error creating schema: " + e.getMessage());
        }
    }

    public void createTableForSpecies(String species) {
        String sql = String.format("CREATE TABLE IF NOT EXISTS public.%s ("
                + "id SERIAL PRIMARY KEY, "
                + "species VARCHAR(50) NOT NULL, "
                + "name VARCHAR(50) NOT NULL, "
                + "birthdate DATE NOT NULL, "
                + "breed VARCHAR(50), "
                + "type VARCHAR(20) NOT NULL, "
                + "distance DOUBLE PRECISION NOT NULL, "
                + "load_capacity DOUBLE PRECISION NOT NULL);", species);
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            view.displayMessage("Error creating table for species: " + e.getMessage());
        }
    }

    public void createAnimal(PackAnimal packAnimal) {
        createTableForSpecies(packAnimal.getSpecies());
        String sql = String.format("INSERT INTO public.%s (species, name, birthdate, breed, type, distance, load_capacity) VALUES (?, ?, ?, ?, ?, ?, ?)", packAnimal.getSpecies());

        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, packAnimal.getSpecies());
            statement.setString(2, packAnimal.getName());
            statement.setDate(3, java.sql.Date.valueOf(packAnimal.getBirthDate()));
            statement.setString(4, packAnimal.getBreed());
            statement.setString(5, packAnimal.getType());
            statement.setDouble(6, packAnimal.getDistance());
            statement.setDouble(7, packAnimal.getLoadCapacity());
            statement.executeUpdate();
            view.displayMessage("Pack animal added successfully!");
        } catch (SQLException e) {
            view.displayMessage("Error adding pack animal: " + e.getMessage());
        }
    }

    public List<PackAnimal> getAnimals() {
        List<PackAnimal> packAnimals = new ArrayList<>();
        String tableQuery = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
        String columnQuery = "SELECT column_name FROM information_schema.columns WHERE table_name = ?";

        try (Connection connection = dbConnection.connect(); PreparedStatement tableStatement = connection.prepareStatement(tableQuery); ResultSet tableResultSet = tableStatement.executeQuery()) {

            while (tableResultSet.next()) {
                String tableName = tableResultSet.getString("table_name");
                try (PreparedStatement columnStatement = connection.prepareStatement(columnQuery)) {
                    columnStatement.setString(1, tableName);
                    ResultSet columnResultSet = columnStatement.executeQuery();
                    boolean hasDistanceColumn = false;
                    boolean hasLoadCapacityColumn = false;

                    while (columnResultSet.next()) {
                        String columnName = columnResultSet.getString("column_name");
                        if ("distance".equals(columnName)) {
                            hasDistanceColumn = true;
                        }
                        if ("load_capacity".equals(columnName)) {
                            hasLoadCapacityColumn = true;
                        }
                    }

                    if (hasDistanceColumn && hasLoadCapacityColumn) {
                        String sql = String.format("SELECT species, name, birthdate, breed, type, distance, load_capacity FROM %s", tableName);
                        try (PreparedStatement animalStatement = connection.prepareStatement(sql); ResultSet resultSet = animalStatement.executeQuery()) {
                            while (resultSet.next()) {
                                PackAnimal packAnimal = new PackAnimal(
                                        resultSet.getString("species"),
                                        resultSet.getString("name"),
                                        resultSet.getDate("birthdate").toLocalDate(),
                                        resultSet.getString("breed"),
                                        resultSet.getString("type"),
                                        resultSet.getDouble("distance"),
                                        resultSet.getDouble("load_capacity")
                                );
                                packAnimals.add(packAnimal);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            view.displayMessage("Error retrieving pack animals: " + e.getMessage());
        }

        return packAnimals;
    }
}
