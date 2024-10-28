package view;

import java.util.List;
import java.util.Scanner;

import model.PackAnimal;
import model.PetAnimal;

public class AnimalManagementView {

    private final Scanner scanner = new Scanner(System.in);

    public int getManagementChoice() {
        System.out.println("Make choice:");
        System.out.println("1. Save all animals to file");
        System.out.println("2. Filter by age");
        System.out.println("0. Exit to main menu");
        return scanner.nextInt();
    }

    public int getFilterAge() {
        System.out.print("Enter age to filter: ");
        return scanner.nextInt();
    }

    public void displayFilteredAnimals(List<PackAnimal> filteredPackAnimals, List<PetAnimal> filteredPetAnimals) {
        System.out.println("Filtered animals:");
        if ((filteredPackAnimals == null || filteredPackAnimals.isEmpty())
                && (filteredPetAnimals == null || filteredPetAnimals.isEmpty())) {
            System.out.println("There are no filtered animals to display");
            return;
        }
        if (filteredPackAnimals != null) {
            for (PackAnimal animal : filteredPackAnimals) {
                System.out.println(animal);
            }
        }
        if (filteredPetAnimals != null) {
            for (PetAnimal animal : filteredPetAnimals) {
                System.out.println(animal);
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void manageAnimals() {
        while (true) {
            int choice = getManagementChoice();
            switch (choice) {
                case 1 -> {
                    showMessage("Saving all animals to file...");
                }
                case 2 -> {
                    int age = getFilterAge();
                    showMessage("Filtering animals by age: " + age);
                }
                case 0 -> {
                    showMessage("Exiting to main menu...");
                    return;
                }
                default ->
                    showMessage("Invalid choice, please try again.");
            }
        }
    }
}
