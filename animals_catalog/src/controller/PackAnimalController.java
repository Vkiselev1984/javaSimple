package controller;

import java.util.List;

import model.PackAnimal;
import services.PackAnimalService;

public class PackAnimalController {

    private final PackAnimalService packAnimalService;

    public PackAnimalController(PackAnimalService packAnimalService) {
        this.packAnimalService = packAnimalService;
    }

    public void addPackAnimal(PackAnimal packAnimal) {
        packAnimalService.createAnimal(packAnimal);
    }

    public List<PackAnimal> getAnimals() {
        return packAnimalService.getAnimals();
    }
}
