# The database of the animal nursery

## Introduction

Development of an application for an animal nursery as part of the control work on the specialization "Developer".

Task: to write a program that simulates the operation of the pet registry.

The program should implement the functionality of working with DB. The user must be able to create, read and edit data. The application must provide a user-friendly interface for operation, comply with the principles of OOP and MVC.

## Realization

The program should contain classes of domestic and pack animals that have common and special fields.

[Animal class](./model/Animal.java): An abstract class that implements the [AnimalInterface interface](./interfaces/AnimalInterface.java). It contains common properties and methods for all animals, such as species, name, birthDate, breed, type, and the getAge() method.

[PackAnimal](./model/PackAnimal.java) and [PetAnimal](./model/PetAnimal.java): Specific classes that inherit from Animal. They can add specific properties and techniques unique to each type of animal.

AnimalInterface: An interface that defines a contract for animal classes. It ensures that all classes implementing it will have specific methods such as getSpecies(), getName(), etc.
