// Программа заполняет массив из 1000 элементов случайными цифрами от 0 до 24.
// С помощью метода calculateUniquePercentage вычисляется процент уникальных значений в данном массиве и
// возвращается в виде числа с плавающей запятой.
// Для вычисления процента используется формула:
// Процент уникальных чисел = Количество уникальных чисел * 100 / Общее количество чисел в массиве.

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class UniquePercentageCalculator {
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000, 25);
        double uniquePercentage = calculateUniquePercentage(array);
        System.out.println("Процент уникальных чисел в массиве: " + uniquePercentage + "%");
    }

    public static int[] generateRandomArray(int size, int maxNumber) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxNumber + 1);
        }
        return array;
    }

    public static double calculateUniquePercentage(int[] array) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : array) {
            uniqueNumbers.add(num);
        }
        int uniqueCount = uniqueNumbers.size();
        double uniquePercentage = (double) uniqueCount * 100 / array.length;
        return uniquePercentage;
    }
}