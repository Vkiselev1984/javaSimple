// Программа возвращает содержимое текущей папки в виде массива строк.
// Метод записывает массив, возвращенный предыдущим методом в файл.
// С помощью try-catch конструкции обрабатывается ошибка.
// В случае возникновения исключения, оно должно записаться в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class FileOperations {
    public static String[] getCurrentDirectoryContents() {
        File currentDirectory = new File(".");
        return currentDirectory.list();
    }

    public static void writeArrayToFile(String[] array, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String item : array) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("Массив успешно записан в файл " + fileName);
        } catch (IOException e) {
            try (BufferedWriter logWriter = new BufferedWriter(new FileWriter("error.log"))) {
                logWriter.write("Ошибка при записи в файл: " + e.getMessage());
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            } catch (IOException ex) {
                System.err.println("Ошибка при записи в лог-файл: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String[] directoryContents = getCurrentDirectoryContents();
        String fileName = "directory_contents.txt";

        writeArrayToFile(directoryContents, fileName);
    }
}