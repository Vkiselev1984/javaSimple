package view;

import java.util.List;
import java.util.Scanner;

public class DatabaseView {

    private final Scanner scanner;

    public DatabaseView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTables(List<String> tables) {
        System.out.println("Tables that the database contains:");
        for (String table : tables) {
            System.out.println("- " + table);
        }
    }

    public String getFileName() {
        System.out.print("Enter file name (for example animals.csv): ");
        return scanner.nextLine();
    }

    public String getTableNames() {
        System.out.print("Enter the names of the tables separated by commas: ");
        return scanner.nextLine();
    }

    public void displayTableData(String tableName, List<String> data) {
        System.out.println("Data from the table " + tableName + ":");
        for (String row : data) {
            System.out.println(row);
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
