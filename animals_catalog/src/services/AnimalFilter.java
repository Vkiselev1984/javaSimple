package services;

import java.util.List;
import java.util.stream.Collectors;
import model.Animal;
import model.PackAnimal;

public class AnimalFilter {

    public <T extends Animal> List<T> filterAnimalsByAge(List<T> animals, int age) {
        return animals.stream()
                .filter(animal -> animal.getAge() == age)
                .collect(Collectors.toList());
    }

    public <T extends Animal> List<T> filterAnimalsByDistance(List<T> animals, double distance) {
        return animals.stream()
                .filter(animal -> animal instanceof PackAnimal && ((PackAnimal) animal).getDistance() >= distance)
                .collect(Collectors.toList());
    }

    public <T extends Animal> List<T> filterAnimalsByLoadCapacity(List<T> animals, double loadCapacity) {
        return animals.stream()
                .filter(animal -> animal instanceof PackAnimal && ((PackAnimal) animal).getLoadCapacity() >= loadCapacity)
                .collect(Collectors.toList());
    }

    public <T extends Animal> List<T> filterAnimalsByAgeRange(List<T> animals, int minAge, int maxAge) {
        return animals.stream()
                .filter(animal -> animal.getAge() >= minAge && animal.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public <T extends Animal> List<T> filterAnimalsByName(List<T> animals, String name) {
        return animals.stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
