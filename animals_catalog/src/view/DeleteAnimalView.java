package view;

import java.util.Scanner;

import controller.DeleteAnimalController;

public class DeleteAnimalView {

    private final DeleteAnimalController deleteAnimalController;
    private final Scanner scanner;

    public DeleteAnimalView(DeleteAnimalController deleteAnimalController) {
        this.deleteAnimalController = deleteAnimalController;
        this.scanner = new Scanner(System.in);
    }

    public void promptUserForDelete() {
        System.out.print("Enter the name of the animal to remove: ");
        String name = scanner.nextLine().trim();
        String searchResult = deleteAnimalController.findAnimalByName(name);
        System.out.println(searchResult);

        if (searchResult.contains("Animal not found")) {
            return;
        }

        int animalCount = countAnimalsInResult(searchResult);

        if (animalCount == 1) {
            int animalId = extractIdFromResult(searchResult);
            String species = extractSpeciesFromResult(searchResult);
            boolean success = deleteAnimalController.deleteAnimal(animalId, species);
            if (success) {
                System.out.println("Animal has been successfully removed");
            } else {
                System.out.println("Error while deleting animal");
            }
        } else {
            System.out.print("Enter the type of animal (eg dog or camel): ");
            String species = scanner.nextLine().trim();
            System.out.print("Enter the ID of the animal to remove: ");
            int idToDelete = scanner.nextInt();
            boolean success = deleteAnimalController.deleteAnimal(idToDelete, species);
            if (success) {
                System.out.println("Animal has been successfully removed");
            } else {
                System.out.println("Error while deleting animal");
            }
        }
    }

    private int countAnimalsInResult(String result) {
        String[] lines = result.split("\n");
        int count = 0;
        for (String line : lines) {
            if (line.contains("id:")) {
                count++;
            }
        }
        return count;
    }

    private int extractIdFromResult(String result) {
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.contains("id:")) {
                String[] parts = line.split(", ");
                for (String part : parts) {
                    if (part.startsWith("id:")) {
                        return Integer.parseInt(part.split(": ")[1]);
                    }
                }
            }
        }
        return -1;
    }

    private String extractSpeciesFromResult(String result) {
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.startsWith("Results for the table:")) {
                return line.split(": ")[1];
            }
        }
        return "";
    }

    public void closeScanner() {
        scanner.close();
    }
}
