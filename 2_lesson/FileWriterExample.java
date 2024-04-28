// Программа составляет строку, состоящую из 100 повторений слова TEST.
// С помощью метода строка записывается в файл.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static String generateTestString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("TEST ");
        }
        return sb.toString();
    }

    public static void writeToFile(String content, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Строка успешно записана в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String testString = generateTestString();
        String fileName = "test.txt";

        writeToFile(testString, fileName);
    }
}