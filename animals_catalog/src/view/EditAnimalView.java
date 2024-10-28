package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.EditAnimalController;

public class EditAnimalView {

    private final EditAnimalController editAnimalController;
    private final Scanner scanner;

    public EditAnimalView(EditAnimalController editAnimalController) {
        this.editAnimalController = editAnimalController;
        this.scanner = new Scanner(System.in);
    }

    public void promptUserForEdit() {
        System.out.print("Enter the animal name to edit: ");
        String name = scanner.nextLine().trim();
        String searchResult = editAnimalController.findAnimalByName(name);
        System.out.println(searchResult);

        if (searchResult.contains("Animal not found.")) {
            return;
        }

        System.out.print("Enter the type of animal (eg dog or camel): ");
        String species = scanner.nextLine().trim();

        System.out.print("Enter animal ID to edit: ");
        int animalId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the new owner name: ");
        String newOwnerName = scanner.nextLine().trim();

        System.out.print("Enter new commands (separated by commas): ");
        String commandsInput = scanner.nextLine().trim();
        List<String> newCommands = new ArrayList<>();
        if (!commandsInput.isEmpty()) {
            String[] commandsArray = commandsInput.split(",");
            for (String command : commandsArray) {
                newCommands.add(command.trim());
            }
        }

        boolean success = editAnimalController.editAnimal(animalId, species, newOwnerName, newCommands);
        if (success) {
            System.out.println("Animal data updated successfully");
        } else {
            System.out.println("Error updating animal data");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
