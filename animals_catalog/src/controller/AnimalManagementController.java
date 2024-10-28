package controller;

import java.io.IOException;
import java.util.List;

import model.DatabaseConnection;
import model.PackAnimal;
import model.PetAnimal;
import services.AnimalFileSaver;
import services.AnimalFilter;
import services.PackAnimalService;
import services.PetAnimalService;
import view.AnimalManagementView;
import view.ConsoleView;

public class AnimalManagementController {

    private final PackAnimalService packAnimalService;
    private final PetAnimalService petAnimalService;
    private final AnimalManagementView animalManagementView;
    private final AnimalFilter animalFilter;
    private final AnimalFileSaver animalFileSaver;

    public AnimalManagementController(DatabaseConnection dbConnection, ConsoleView consoleView, AnimalManagementView view, String filePath) {
        this.packAnimalService = new PackAnimalService(dbConnection, consoleView);
        this.petAnimalService = new PetAnimalService(dbConnection, consoleView);
        this.animalManagementView = view;
        this.animalFilter = new AnimalFilter();
        this.animalFileSaver = new AnimalFileSaver(filePath);
    }

    public void displayManagementMenu() {
        while (true) {
            int choice = animalManagementView.getManagementChoice();

            switch (choice) {
                case 1 -> {
                    clearConsole();
                    saveAnimalsToFile();
                }
                case 2 -> {
                    clearConsole();
                    filterAnimalsByAge();
                }
                case 0 -> {
                    System.out.println("Returned to main menu");
                    return;
                }
                default ->
                    animalManagementView.showMessage("Incorrect selection. Please try again");
            }
        }
    }

    private void saveAnimalsToFile() {
        List<PackAnimal> packAnimals = packAnimalService.getAnimals();
        List<PetAnimal> petAnimals = petAnimalService.getAnimals();

        animalFileSaver.saveAllAnimals(packAnimals, petAnimals);
        System.out.println("Successfully saved to file");
    }

    private void filterAnimalsByAge() {
        int age = animalManagementView.getFilterAge();
        animalManagementView.displayFilteredAnimals(
                animalFilter.filterAnimalsByAge(packAnimalService.getAnimals(), age),
                animalFilter.filterAnimalsByAge(petAnimalService.getAnimals(), age)
        );
    }

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error clearing console: " + e.getMessage());
        }
    }
}
