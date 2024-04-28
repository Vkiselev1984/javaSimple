// Программа замеряет время, за которое в ArrayList добавятся 1000000 элементов.
// А также за которое в LinkedList добавятся 1000000 элементов.
// Тоже самое для считывания данных из ArrayList и LinkedList.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAddPerformance {
    
    public static void main(String[] args) {
        long startTime;
        long endTime;
        long durationArrayList;
        long durationLinkedList;
        
        // Добавление 1000000 элементов в ArrayList
        List<Integer> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        durationArrayList = endTime - startTime;
        System.out.println("Время добавления 1000000 элементов в ArrayList: " + durationArrayList + " нс");
        
        // Добавление 1000000 элементов в LinkedList
        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        durationLinkedList = endTime - startTime;
        System.out.println("Время добавления 1000000 элементов в LinkedList: " + durationLinkedList + " нс");
        
        // Считывание данных из ArrayList
        startTime = System.nanoTime();
        for (Integer num : arrayList) {
            // Просто проходим по элементам
        }
        endTime = System.nanoTime();
        long readTimeArrayList = endTime - startTime;
        System.out.println("Время считывания данных из ArrayList: " + readTimeArrayList + " нс");
        
        // Считывание данных из LinkedList
        startTime = System.nanoTime();
        for (Integer num : linkedList) {
            // Просто проходим по элементам
        }
        endTime = System.nanoTime();
        long readTimeLinkedList = endTime - startTime;
        System.out.println("Время считывания данных из LinkedList: " + readTimeLinkedList + " нс");
    }
}