package services;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException; // Импортируем класс Array
import java.util.List;

import model.DatabaseConnection;

public class EditAnimalService {

    private final DatabaseConnection dbConnection;

    public EditAnimalService(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public boolean editAnimal(int animalId, String species, String newOwnerName, List<String> newCommands) {
        String query = "UPDATE " + species + " SET owner_name = ?, commands = ? WHERE id = ?";
        try (PreparedStatement statement = dbConnection.connect().prepareStatement(query)) {
            statement.setString(1, newOwnerName);
            Array commandsArray = dbConnection.connect().createArrayOf("text", newCommands.toArray());
            statement.setArray(2, commandsArray);
            statement.setInt(3, animalId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
