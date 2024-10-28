package view;

import java.util.Scanner;

import controller.AnimalSearchController;

public class AnimalSearchView {

    private final AnimalSearchController animalSearchController;
    private final Scanner scanner;

    public AnimalSearchView(AnimalSearchController animalSearchController) {
        this.animalSearchController = animalSearchController;
        this.scanner = new Scanner(System.in);
    }

    public void promptUserForSearch() {
        System.out.print("Enter the name of the animal: ");
        String name = scanner.nextLine();

        String result = animalSearchController.searchAnimal(name);
        System.out.println(result);
    }

    public void closeScanner() {
        scanner.close();
    }
}
