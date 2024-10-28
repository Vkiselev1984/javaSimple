package controller;

import java.util.List;

import model.PetAnimal;
import services.PetAnimalService;

public class PetAnimalController {

    private final PetAnimalService petAnimalService;

    public PetAnimalController(PetAnimalService petAnimalService) {
        this.petAnimalService = petAnimalService;
    }

    public void createAnimal(PetAnimal pet) {
        petAnimalService.createAnimal(pet);
    }

    public List<PetAnimal> getAnimals() {
        return petAnimalService.getAnimals();
    }
}
