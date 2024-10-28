package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DatabaseConnection;

public class FindAnimalByNameService {

    private final DatabaseConnection dbConnection;

    public FindAnimalByNameService(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String findAnimalByName(String name) {
        StringBuilder result = new StringBuilder();
        String queryTables = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";

        try (Connection conn = dbConnection.connect(); PreparedStatement stmt = conn.prepareStatement(queryTables)) {
            ResultSet tablesResultSet = stmt.executeQuery();

            while (tablesResultSet.next()) {
                String tableName = tablesResultSet.getString("table_name");
                String query = "SELECT * FROM " + tableName + " WHERE name ILIKE ?";
                try (PreparedStatement searchStmt = conn.prepareStatement(query)) {
                    searchStmt.setString(1, name);
                    ResultSet rs = searchStmt.executeQuery();

                    if (rs.next()) {
                        result.append("Results for the table: ").append(tableName).append("\n");
                        do {
                            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                String columnName = rs.getMetaData().getColumnName(i);
                                String columnValue = rs.getString(i);
                                result.append(columnName).append(": ").append(columnValue).append(", ");
                            }
                            result.setLength(result.length() - 2);
                            result.append("\n");
                        } while (rs.next());
                    }
                } catch (SQLException e) {
                    System.out.println("Error while searching in table " + tableName + ": " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error getting list of tables";
        }

        if (result.length() == 0) {
            return "Animal not found";
        } else {
            return result.toString();
        }
    }
}
