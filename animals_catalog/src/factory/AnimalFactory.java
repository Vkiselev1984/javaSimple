package factory;

import java.time.LocalDate;
import java.util.List;
import model.PackAnimal;
import model.PetAnimal;

public class AnimalFactory {

    public static PetAnimal createPetAnimal(String species, String name, LocalDate birthDate, String breed, String type, String ownerName, List<String> commands) {
        return new PetAnimal(species, name, birthDate, breed, type, ownerName, commands);
    }

    public static PackAnimal createPackAnimal(String species, String name, LocalDate birthDate, String breed, String type, double distance, double loadCapacity) {
        return new PackAnimal(species, name, birthDate, breed, type, distance, loadCapacity);
    }
}
