package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PetAnimal extends Animal {

    private String ownerName;
    private List<String> commands;

    public PetAnimal(String species, String name, LocalDate birthDate, String breed, String type, String ownerName, List<String> commands) {
        super(species, name, birthDate, breed, type);
        this.ownerName = ownerName;
        this.commands = commands;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "PetAnimal{"
                + "species='" + getSpecies() + '\''
                + ", name='" + getName() + '\''
                + ", birthDate=" + getBirthDate()
                + ", breed='" + getBreed() + '\''
                + ", type='" + getType() + '\''
                + ", ownerName='" + ownerName + '\''
                + ", commands=" + commands
                + ", age=" + getAge()
                + '}';
    }
}
