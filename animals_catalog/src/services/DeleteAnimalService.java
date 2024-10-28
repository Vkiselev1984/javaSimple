package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DatabaseConnection;

public class DeleteAnimalService {

    private final DatabaseConnection dbConnection;

    public DeleteAnimalService(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public boolean deleteAnimal(int animalId, String species) {
        return deleteAnimalById(animalId, species);
    }

    private boolean deleteAnimalById(int animalId, String tableName) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = dbConnection.connect().prepareStatement(query)) {
            statement.setInt(1, animalId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
