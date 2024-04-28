// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.List;

public class RemoveEvenNumbers {
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        
        // Удаление четных чисел из списка
        numbers.removeIf(num -> num % 2 == 0);
        
        // Вывод списка после удаления четных чисел
        System.out.println("Список после удаления четных чисел:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}