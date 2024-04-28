// Программа определяет тип (расширение) файлов из текущей папки и выводит в консоль результат вида
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg

import java.io.File;

public class FileExtensionChecker {
    public static void listFileExtensions() {
        File currentDirectory = new File(".");
        File[] files = currentDirectory.listFiles();

        if (files != null) {
            int count = 1;
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    int dotIndex = fileName.lastIndexOf(".");
                    if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
                        String extension = fileName.substring(dotIndex + 1);
                        System.out.println(count + " Расширение файла: " + extension);
                        count++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        listFileExtensions();
    }
}