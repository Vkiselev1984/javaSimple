package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import model.PackAnimal;
import model.PetAnimal;

public class AnimalFileSaver {

    private final Path directoryPath;

    public AnimalFileSaver(String filePath) {
        if (!filePath.endsWith("/") && !filePath.endsWith("\\")) {
            filePath += "/";
        }

        this.directoryPath = Paths.get(filePath);
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                System.err.println("Error creating directory: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void saveAllAnimals(List<PackAnimal> packAnimals, List<PetAnimal> petAnimals) {
        savePackAnimalsToFile(packAnimals);
        savePetAnimalsToFile(petAnimals);
    }

    private void writeAnimalsToFile(String fileName, List<?> animals, String header) {
        Path filePath = directoryPath.resolve(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
            writer.write(header);
            writer.newLine();
            for (Object animal : animals) {
                writer.write(formatAnimalData(animal));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving animals to file " + fileName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void savePackAnimalsToFile(List<PackAnimal> animals) {
        writeAnimalsToFile("packAnimals.csv", animals, "Name,Breed,Type,Distance,LoadCapacity");
    }

    public void savePetAnimalsToFile(List<PetAnimal> animals) {
        writeAnimalsToFile("petAnimals.csv", animals, "Name,Breed,Type,OwnerName");
    }

    private String formatAnimalData(Object animal) {
        return switch (animal) {
            case PackAnimal pack ->
                String.join(",", pack.getName(), pack.getBreed(), pack.getType(),
                String.valueOf(pack.getDistance()), String.valueOf(pack.getLoadCapacity()));
            case PetAnimal pet ->
                String.join(",", pet.getName(), pet.getBreed(), pet.getType(), pet.getOwnerName());
            default ->
                "";
        };
    }
}
