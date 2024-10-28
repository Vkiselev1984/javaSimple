package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import factory.AnimalFactory;
import model.DatabaseConnection;
import model.PackAnimal;
import model.PetAnimal;
import services.PackAnimalService;
import services.PetAnimalService;
import view.ConsoleView;

public class CreateAnimal {

    private final ConsoleView view;
    private final PetAnimalController petController;
    private final PackAnimalController packAnimalController;

    public CreateAnimal(ConsoleView view, DatabaseConnection dbConnection) {
        this.view = view;
        PetAnimalService petAnimalService = new PetAnimalService(dbConnection, view);
        PackAnimalService packAnimalService = new PackAnimalService(dbConnection, view);
        this.petController = new PetAnimalController(petAnimalService);
        this.packAnimalController = new PackAnimalController(packAnimalService);
    }

    public void execute() {
        String species = view.getInput("Enter the animal species (cat/dog/bird/fish): ");
        String name = view.getInput("Enter nickname: ");
        LocalDate birthDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        while (birthDate == null) {
            String birthDateInput = view.getInput("Enter date of birth (DD.MM.YYYY): ");
            try {
                birthDate = LocalDate.parse(birthDateInput, formatter);
            } catch (DateTimeParseException e) {
                view.displayMessage("Invalid date format. Please enter a date in the format DD.MM.YYYY.");
            }
        }

        String breed = view.getInput("Enter breed: ");
        String type = view.getInput("Enter type (pet/pack): ");

        if (type.equalsIgnoreCase("pet")) {
            String ownerName = view.getInput("Enter the owner's name: ");
            List<String> commands = new ArrayList<>();
            String command;
            do {
                command = view.getInput("Enter command (or 'stop' to quit): ");
                if (!command.equalsIgnoreCase("stop")) {
                    commands.add(command);
                }
            } while (!command.equalsIgnoreCase("stop"));

            PetAnimal petAnimal = AnimalFactory.createPetAnimal(species, name, birthDate, breed, type, ownerName, commands);
            petController.createAnimal(petAnimal);
        } else if (type.equalsIgnoreCase("pack")) {
            double distance = Double.parseDouble(view.getInput("Enter the distance: "));
            double loadCapacity = Double.parseDouble(view.getInput("Enter the load capacity: "));
            PackAnimal packAnimal = AnimalFactory.createPackAnimal(species, name, birthDate, breed, type, distance, loadCapacity);
            packAnimalController.addPackAnimal(packAnimal);
        } else {
            view.displayMessage("Invalid animal type. Please enter 'pet' or 'pack'.");
        }
    }
}
