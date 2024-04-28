// Заполнить список десятью случайными числами.
// Отсортировать список методом sort() и вывести его на экран.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNumberSorting {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Заполнение списка десятью случайными числами
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100)); // Генерация случайного числа от 0 до 99
        }

        // Сортировка списка
        Collections.sort(numbers);

        // Вывод отсортированного списка на экран
        System.out.println("Отсортированный список случайных чисел:");
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}