package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseConnection;
import model.PetAnimal;
import view.ConsoleView;

public class PetAnimalService {

    private final DatabaseConnection dbConnection;
    private final ConsoleView view;

    public PetAnimalService(DatabaseConnection dbConnection, ConsoleView view) {
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
                + "owner_name VARCHAR(50), "
                + "commands TEXT[]);",
                species);
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            view.displayMessage("Error creating table for species: " + e.getMessage());
        }
    }

    public void createAnimal(PetAnimal petAnimal) {
        createTableForSpecies(petAnimal.getSpecies());
        String sql = String.format("INSERT INTO public.%s (species, name, birthdate, breed, type, owner_name, commands) VALUES (?, ?, ?, ?, ?, ?, ?)", petAnimal.getSpecies());

        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, petAnimal.getSpecies());
            statement.setString(2, petAnimal.getName());
            statement.setDate(3, java.sql.Date.valueOf(petAnimal.getBirthDate()));
            statement.setString(4, petAnimal.getBreed());
            statement.setString(5, petAnimal.getType());
            statement.setString(6, petAnimal.getOwnerName());
            statement.setArray(7, connection.createArrayOf("text", petAnimal.getCommands().toArray()));
            statement.executeUpdate();
            view.displayMessage("Pet animal added successfully!");
        } catch (SQLException e) {
            view.displayMessage("Error adding pet animal: " + e.getMessage());
        }
    }

    public List<PetAnimal> getAnimals() {
        List<PetAnimal> petAnimals = new ArrayList<>();
        String tableQuery = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
        String columnQuery = "SELECT column_name FROM information_schema.columns WHERE table_name = ?";

        try (Connection connection = dbConnection.connect(); PreparedStatement tableStatement = connection.prepareStatement(tableQuery); ResultSet tableResultSet = tableStatement.executeQuery()) {

            while (tableResultSet.next()) {
                String tableName = tableResultSet.getString("table_name");
                try (PreparedStatement columnStatement = connection.prepareStatement(columnQuery)) {
                    columnStatement.setString(1, tableName);
                    ResultSet columnResultSet = columnStatement.executeQuery();
                    boolean hasOwnerNameColumn = false;
                    boolean hasCommandsColumn = false;

                    while (columnResultSet.next()) {
                        String columnName = columnResultSet.getString("column_name");
                        if ("owner_name".equals(columnName)) {
                            hasOwnerNameColumn = true;
                        }
                        if ("commands".equals(columnName)) {
                            hasCommandsColumn = true;
                        }
                    }

                    if (hasOwnerNameColumn && hasCommandsColumn) {
                        String sql = String.format("SELECT species, name, birthdate, breed, type, owner_name, commands FROM %s", tableName);
                        try (PreparedStatement animalStatement = connection.prepareStatement(sql); ResultSet resultSet = animalStatement.executeQuery()) {
                            while (resultSet.next()) {
                                PetAnimal petAnimal = new PetAnimal(
                                        resultSet.getString("species"),
                                        resultSet.getString("name"),
                                        resultSet.getDate("birthdate").toLocalDate(),
                                        resultSet.getString("breed"),
                                        resultSet.getString("type"),
                                        resultSet.getString("owner_name"),
                                        List.of((String[]) resultSet.getArray("commands").getArray())
                                );
                                petAnimals.add(petAnimal);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            view.displayMessage("Error retrieving pet animals: " + e.getMessage());
        }

        return petAnimals;
    }
}
