package view;

import controller.AnimalManagementController;
import java.util.List;
import model.DatabaseConnection;
import model.PackAnimal;
import model.PetAnimal;
import services.PackAnimalService;
import services.PetAnimalService;

public class AnimalsView {

    private final PetAnimalService petAnimalService;
    private final PackAnimalService packAnimalService;
    private final AnimalManagementController animalManagementController;

    public AnimalsView(DatabaseConnection dbConnection, ConsoleView view) {
        this.petAnimalService = new PetAnimalService(dbConnection, view);
        this.packAnimalService = new PackAnimalService(dbConnection, view);
        this.animalManagementController = new AnimalManagementController(dbConnection, view, new AnimalManagementView(), "saveFiles/");
    }

    public void viewAllAnimals() {
        List<PetAnimal> petAnimals = petAnimalService.getAnimals();
        List<PackAnimal> packAnimals = packAnimalService.getAnimals();

        List<String> petAnimalOutputs = getPetAnimalOutputs(petAnimals);
        List<String> packAnimalOutputs = getPackAnimalOutputs(packAnimals);

        System.out.println("Pet Animals:");
        if (petAnimalOutputs.isEmpty()) {
            System.out.println("No pet animals found.");
        } else {
            petAnimalOutputs.forEach(System.out::println);
        }

        System.out.println("Pack Animals:");
        if (packAnimalOutputs.isEmpty()) {
            System.out.println("No pack animals found.");
        } else {
            packAnimalOutputs.forEach(System.out::println);
        }

        animalManagementController.displayManagementMenu();
    }

    public List<String> getPetAnimalOutputs(List<PetAnimal> pets) {
        return pets.stream()
                .map(this::formatAnimalOutput)
                .toList();
    }

    public List<String> getPackAnimalOutputs(List<PackAnimal> packAnimals) {
        return packAnimals.stream()
                .map(this::formatAnimalOutput)
                .toList();
    }

    private String formatAnimalOutput(PetAnimal animal) {
        return "PetAnimal: " + animal.toString();
    }

    private String formatAnimalOutput(PackAnimal animal) {
        return "PackAnimal: " + animal.toString();
    }
}
