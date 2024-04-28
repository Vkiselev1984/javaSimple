// Программа реализовывает стэк с помощью массива.
// Используются методы: // size(), empty(), push(), peek(), pop(). 

public class StackArrayExample {
    private static int[] stackArray;
    private static int capacity;
    private static int top;

    public static void main(String[] args) {
        capacity = 5;
        stackArray = new int[capacity];
        top = -1;
        System.out.println(size());
        System.out.println(empty());
        push(5);
        push(3);
        push(1);
        System.out.println(size());
        System.out.println(empty());
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(size());
    }

    public static int size() {
        return top + 1;
    }

    public static boolean empty() {
        return top == -1;
    }
    
    public static void push(int value) {
        stackArray[++top] = value;
    }

    public static int peek() {
        return stackArray[top];
    }

    public static int pop() {
        return stackArray[top--];
    }
}