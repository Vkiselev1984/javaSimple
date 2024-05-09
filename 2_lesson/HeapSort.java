// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

public class HeapSort
{
    public void sort(int arr[])
    {
        int n = arr.length;
        // Построение кучи
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // Извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Вызываем функцию heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }
    // Функция для преобразования в двоичную кучу поддерева с корневым узлом i (индекс в arr[], n - размер кучи)
     void heapify(int arr[], int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый
            int r = 2*i + 2; // правый
           // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;
          // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
       // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
          // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Отсортированный массив: ");
        printArray(arr);
    }
}