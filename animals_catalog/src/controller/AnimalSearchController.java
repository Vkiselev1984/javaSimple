package controller;

import services.FindAnimalByNameService;

public class AnimalSearchController {

    private final FindAnimalByNameService findAnimalByNameService;

    public AnimalSearchController(FindAnimalByNameService findAnimalByNameService) {
        this.findAnimalByNameService = findAnimalByNameService;
    }

    public String searchAnimal(String name) {
        return findAnimalByNameService.findAnimalByName(name);
    }
}
