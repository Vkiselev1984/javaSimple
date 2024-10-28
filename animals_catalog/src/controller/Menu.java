package controller;

import java.io.IOException;
import java.util.Scanner;
import model.DatabaseConnection;
import services.DeleteAnimalService;
import services.EditAnimalService;
import services.FindAnimalByNameService;
import view.AnimalSearchView;
import view.AnimalsView;
import view.ConsoleView;
import view.DeleteAnimalView;
import view.EditAnimalView;

public class Menu {

    private final CreateAnimal createAnimal;
    private final AnimalSearchController animalSearchController;
    private final AnimalSearchView animalSearchView;
    private final DeleteAnimalController deleteAnimalController;
    private final DeleteAnimalView deleteAnimalView;
    private final EditAnimalController editAnimalController;
    private final EditAnimalView editAnimalView;
    private final Scanner scanner;
    private final AnimalsView animalsView;
    private final DatabaseMenuController databaseMenuController;

    public Menu(ConsoleView view, DatabaseConnection dbConnection) {
        this.createAnimal = new CreateAnimal(view, dbConnection);
        this.animalSearchController = new AnimalSearchController(new FindAnimalByNameService(dbConnection));
        this.animalSearchView = new AnimalSearchView(animalSearchController);
        this.deleteAnimalController = new DeleteAnimalController(new DeleteAnimalService(dbConnection), new FindAnimalByNameService(dbConnection));
        this.deleteAnimalView = new DeleteAnimalView(deleteAnimalController);
        this.editAnimalController = new EditAnimalController(new EditAnimalService(dbConnection), new FindAnimalByNameService(dbConnection));
        this.editAnimalView = new EditAnimalView(editAnimalController);
        this.scanner = new Scanner(System.in);
        this.animalsView = new AnimalsView(dbConnection, view);
        this.databaseMenuController = new DatabaseMenuController(dbConnection);
    }

    public void displayMenu() {
        clearConsole();
        while (true) {
            System.out.println("Make choice:");
            System.out.println("1. Register animal in nursery");
            System.out.println("2. Find animal by name");
            System.out.println("3. View all animals in nursery");
            System.out.println("4. Edit animal details");
            System.out.println("5. Remove animal from nursery");
            System.out.println("6. Edit database");
            System.out.println("0. Exit");

            int choice = getUserChoice();

            switch (choice) {
                case 1 -> {
                    clearConsole();
                    createAnimal.execute();
                }
                case 2 -> {
                    clearConsole();
                    animalSearchView.promptUserForSearch();
                }
                case 3 -> {
                    clearConsole();
                    animalsView.viewAllAnimals();
                }
                case 4 -> {
                    clearConsole();
                    editAnimalView.promptUserForEdit();
                }
                case 5 -> {
                    clearConsole();
                    deleteAnimalView.promptUserForDelete();
                }
                case 6 -> {
                    clearConsole();
                    databaseMenuController.displayDatabaseMenu();
                }
                case 0 -> {
                    System.out.println("You have left nursery");
                    return;
                }
                default ->
                    System.out.println("Incorrect selection. Please try again");
            }
        }
    }

    private int getUserChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
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
