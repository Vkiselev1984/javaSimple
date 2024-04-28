// Программа:
// 1. Принимает от пользователя и “запоминает” строки.
// 2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
// 3. Если введено revert, удаляет предыдущую введенную строку из памяти.

import java.util.ArrayList;
import java.util.Scanner;

public class StringMemory {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите строку или команду (print, revert, exit):");
            String input = scanner.nextLine();

            if (input.equals("print")) {
                for (int i = strings.size() - 1; i >= 0; i--) {
                    System.out.println(strings.get(i));
                }
            } else if (input.equals("revert")) {
                if (!strings.isEmpty()) {
                    strings.remove(strings.size() - 1);
                } else {
                    System.out.println("Память пуста");
                }
            } else if (input.equals("exit")) {
                break; // Выход из цикла
            } else {
                strings.add(input);
            }
        }

        scanner.close(); // Закрытие Scanner
    }
}