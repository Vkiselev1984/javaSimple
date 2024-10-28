package controller;

import services.DeleteAnimalService;
import services.FindAnimalByNameService;

public class DeleteAnimalController {

    private final DeleteAnimalService animalService;
    private final FindAnimalByNameService findAnimalByNameService;

    public DeleteAnimalController(DeleteAnimalService animalService, FindAnimalByNameService findAnimalByNameService) {
        this.animalService = animalService;
        this.findAnimalByNameService = findAnimalByNameService;
    }

    public String findAnimalByName(String name) {
        return findAnimalByNameService.findAnimalByName(name);
    }

    public boolean deleteAnimal(int animalId, String species) {
        return animalService.deleteAnimal(animalId, species);
    }
}
