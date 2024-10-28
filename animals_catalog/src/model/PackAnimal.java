package model;

import java.time.LocalDate;
import java.time.Period;

public class PackAnimal extends Animal {

    private double distance;
    private double loadCapacity;

    public PackAnimal(String species, String name, LocalDate birthDate, String breed, String type, double distance, double loadCapacity) {
        super(species, name, birthDate, breed, type);
        this.distance = distance;
        this.loadCapacity = loadCapacity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "PackAnimal{"
                + "species='" + getSpecies() + '\''
                + ", name='" + getName() + '\''
                + ", birthDate=" + getBirthDate()
                + ", breed='" + getBreed() + '\''
                + ", type='" + getType() + '\''
                + ", distance=" + distance
                + ", loadCapacity=" + loadCapacity
                + ", age=" + getAge()
                + '}';
    }
}
