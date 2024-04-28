// Программа реализует очередь для Integer с помощью LinkedList со следующими методами:

// enqueue() - помещает элемент в конец очереди
// dequeue() - возвращает первый элемент из очереди и удаляет его
// first() - возвращает первый элемент из очереди, не удаляя
// getElements() - возвращает все элементы в очереди

import java.util.LinkedList;

class MyQueue {
    private LinkedList<Integer> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(Integer element) {
        queue.add(element);
    }

    public Integer dequeue() {
        return queue.poll(); // Используем poll() для извлечения и удаления первого элемента
    }

    public Integer first() {
        return queue.peek(); // Используем peek() для просмотра первого элемента без удаления
    }

    public LinkedList<Integer> getElements() {
        return new LinkedList<>(queue); // Возвращаем копию очереди, чтобы избежать изменений извне
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(5);
        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}