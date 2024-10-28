package model;

import interfaces.AnimalInterface;
import java.time.LocalDate;
import java.time.Period;

public abstract class Animal implements AnimalInterface {

    private final String species;
    private final String name;
    private final LocalDate birthDate;
    private final String breed;
    private final String type;

    public Animal(String species, String name, LocalDate birthDate, String breed, String type) {
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
        this.breed = breed;
        this.type = type;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getAge() {
        if (birthDate == null) {
            return 0;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public double getAgeWithPrecision() {
        if (birthDate == null) {
            return 0.0;
        }
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);
        return period.getYears() + (period.getMonths() / 12.0);
    }

    @Override
    public String toString() {
        return "Animal{"
                + "species='" + species + '\''
                + ", name='" + name + '\''
                + ", birthDate=" + birthDate
                + ", breed='" + breed + '\''
                + ", type='" + type + '\''
                + ", age=" + getAge()
                + '}';
    }
}
