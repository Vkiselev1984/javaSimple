// Программа демонстрирует использование класса PriorityQueue в Java, который представляет собой очередь с приоритетом:
// Создается объект PriorityQueue с элементами типа Integer.
// С помощью метода add добавляются элементы 123, 3, 13 и 1 в очередь с приоритетом.
// Выводится содержимое очереди с помощью System.out.println(pq);, что покажет элементы в порядке приоритета.
// С помощью метода poll извлекается и удаляется элемент с наивысшим приоритетом из очереди. Последовательно вызывая poll, выводятся элементы в порядке убывания приоритета.
// После извлечения всех элементов из очереди, вызов poll возвращает null.

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(123);
        pq.add(3);
        pq.add(13);
        pq.add(1);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
       

    }
}

