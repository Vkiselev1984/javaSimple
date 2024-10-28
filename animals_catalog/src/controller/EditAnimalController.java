package controller;

import java.util.List;

import services.EditAnimalService;
import services.FindAnimalByNameService;

public class EditAnimalController {

    private final EditAnimalService editAnimalService;
    private final FindAnimalByNameService findAnimalByNameService;

    public EditAnimalController(EditAnimalService editAnimalService, FindAnimalByNameService findAnimalByNameService) {
        this.editAnimalService = editAnimalService;
        this.findAnimalByNameService = findAnimalByNameService;
    }

    public String findAnimalByName(String name) {
        return findAnimalByNameService.findAnimalByName(name);
    }

    public boolean editAnimal(int animalId, String species, String newOwnerName, List<String> newCommands) {
        return editAnimalService.editAnimal(animalId, species, newOwnerName, newCommands);
    }
}
