package controller;

import java.util.List;
import java.util.Scanner;

import model.DatabaseConnection;
import services.DatabaseService;
import view.DatabaseView;

public class DatabaseMenuController {

    private final DatabaseService databaseService;
    private final DatabaseView databaseView;
    private final Scanner scanner;

    public DatabaseMenuController(DatabaseConnection dbConnection) {
        this.databaseService = new DatabaseService(dbConnection);
        this.databaseView = new DatabaseView();
        this.scanner = new Scanner(System.in);
    }

    public void displayDatabaseMenu() {
        while (true) {
            System.out.println("Make choice:");
            System.out.println("1. Delete all database tables");
            System.out.println("2. Upload data from file");
            System.out.println("3. Output list of all tables");
            System.out.println("4. Delete tables");
            System.out.println("5. Merge tables");
            System.out.println("6. Show table contents by name");
            System.out.println("0. Go back to the previous menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1 -> {
                    databaseService.deleteAllTables();
                    System.out.println("Success: all tables deleted");
                }
                case 2 -> {
                    String filename = databaseView.getFileName();
                    databaseService.loadAnimalsFromFile(filename);
                }
                case 3 -> {
                    List<String> tables = databaseService.getExistingTables();
                    databaseView.displayTables(tables);
                }
                case 4 ->
                    deleteSpecificTables();
                case 5 ->
                    mergeTables();
                case 6 ->
                    viewSpecificTables();
                case 0 -> {
                    return;
                }
                default ->
                    System.out.println("Wrong choice, please try again");
            }
        }
    }

    private int getUserChoice() {
        System.out.print("Choose: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter number");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void deleteSpecificTables() {
        System.out.print("Enter the names of the tables separated by commas: ");
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] tableNames = input.split(",");
        for (String tableName : tableNames) {
            databaseService.deleteTable(tableName.trim());
        }
        System.out.println("Success");
    }

    private void mergeTables() {
        System.out.print("Enter the names of the tables to combine separated by commas: ");
        scanner.nextLine();
        String input = scanner.nextLine();
        boolean success = databaseService.mergeTables(input);
        if (success) {
            System.out.println("Success");
        } else {
            System.out.println("Error: tables do not match in structure");
        }
    }

    private void viewSpecificTables() {
        System.out.print("Enter the names of the tables separated by commas: ");
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] tableNames = input.split(",");
        for (String tableName : tableNames) {
            List<String> tableData = databaseService.getTableData(tableName.trim());
            databaseView.displayTableData(tableName.trim(), tableData);
        }
    }
}
