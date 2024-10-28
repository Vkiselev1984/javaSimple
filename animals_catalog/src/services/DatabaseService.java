package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DatabaseConnection;

public class DatabaseService {

    private final DatabaseConnection dbConnection;

    public DatabaseService(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void deleteAllTables() {
        try (Connection connection = dbConnection.connect()) {
            connection.setAutoCommit(false);
            String sql = "DROP SCHEMA public CASCADE";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.executeUpdate();
                connection.commit();
                System.out.println("Success: all tables have been deleted");
            } catch (SQLException e) {
                connection.rollback();
                System.err.println("Error deleting tables: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void loadAnimalsFromFile(String filename) {
        String sql = "INSERT INTO Animals (species, name, age) VALUES (?, ?, ?)";
        try (Connection connection = dbConnection.connect(); BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 3) {
                        statement.setString(1, data[0]);
                        statement.setString(2, data[1]);
                        statement.setInt(3, Integer.parseInt(data[2]));
                        statement.addBatch();
                    }
                }
                statement.executeBatch();
                connection.commit();
                System.out.println("Success: " + filename + " loaded");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error when uploading animals to the database: " + e.getMessage());
        }
    }

    public List<String> getExistingTables() {
        List<String> tables = new ArrayList<>();
        try (Connection connection = dbConnection.connect()) {
            String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    tables.add(resultSet.getString("table_name"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting list of tables: " + e.getMessage());
        }
        return tables;
    }

    public void deleteTable(String tableName) {
        try (Connection connection = dbConnection.connect()) {
            String sql = "DROP TABLE IF EXISTS " + tableName;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.executeUpdate();
                System.out.println("Table " + tableName + " successfully deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting table: " + e.getMessage());
        }
    }

    public boolean mergeTables(String tableNames) {
        String sql = "SELECT * FROM " + tableNames.replace(",", " UNION ALL SELECT * FROM ");
        try (Connection connection = dbConnection.connect(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Species: " + resultSet.getString("species") + ", Name: " + resultSet.getString("name"));
            }
            System.out.println("Tables " + tableNames + " successfully merged");
            return true;
        } catch (SQLException e) {
            System.err.println("Error while merging tables: " + e.getMessage());
            return false;
        }
    }

    public List<String> getTableData(String tableName) {
        List<String> data = new ArrayList<>();
        try (Connection connection = dbConnection.connect()) {
            String sql = "SELECT * FROM " + tableName;
            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String row = "ID: " + resultSet.getInt("id") + ", Species: " + resultSet.getString("species") + ", Name: " + resultSet.getString("name");
                    data.add(row);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting data from table " + tableName + ": " + e.getMessage());
        }
        return data;
    }

}
