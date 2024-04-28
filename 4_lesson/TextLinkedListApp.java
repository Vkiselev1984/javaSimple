// Программа:
// 1. Принимает от пользователя строку вида text~num
// 2. Делит строку по ~, сохраняя text в связный список на позицию num.
// 3. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

import java.util.LinkedList;
import java.util.Scanner;

import java.util.LinkedList;
import java.util.Scanner;

public class TextLinkedListApp {

    public static void main(String[] args) {
        LinkedList<String> textList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите строку вида text~num для добавления в список: ");
            System.out.println("print~num для вывода и удаления элемента из списка");
            System.out.println("Для выхода из программы введите \"q\"");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            input = input.replaceAll("\\s", ""); // Удаление всех пробелов из входной строки

            if (input.startsWith("print~")) {
                int num = Integer.parseInt(input.substring(6));
                if (num >= 0 && num < textList.size()) {
                    String text = textList.get(num);
                    System.out.println("Строка из позиции " + num + ": " + text);
                    textList.remove(num);
                } else {
                    System.out.println("Неверный номер позиции.");
                }
            } else {
                String[] parts = input.split("~");
                if (parts.length == 2) {
                    String text = parts[0];
                    int num = Integer.parseInt(parts[1]);
                    if (num >= 0 && num <= textList.size()) {
                        textList.add(num, text);
                    } else {
                        System.out.println("Неверный номер позиции.");
                    }
                } else {
                    System.out.println("Неверный формат ввода.");
                }
            }
        }

        scanner.close();
    }
}