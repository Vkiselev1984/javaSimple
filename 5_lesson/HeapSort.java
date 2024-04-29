// Программа для сортировки массива целых чисел с использованием сортировки кучей(Heap Sort).
// Программа работает следующим образом:
// Принимает на вход массив целых чисел для сортировки.Если массив не предоставлен,программа использует массив по умолчанию.
// Выводит исходный массив на экран.
// Применяет сортировку кучей(Heap Sort)для сортировки элементов массива в порядке возрастания.
// Выводит отсортированный массив на экран.
// Используются два основных метода:buildTree,который строит сортирующее дерево на основе массива,и heapSort,
// который выполняет сортировку кучей.
// Программа способна сортировать массив,даже если он состоит из отрицательных чисел и имеет дубликаты.


import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        buildTree(sortArray, sortLength);

        for (int i = sortLength - 1; i > 0; i--) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            heapify(sortArray, i, 0);
        }
    }

    private static void heapify(int[] tree, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && tree[left] > tree[largest]) {
            largest = left;
        }

        if (right < n && tree[right] > tree[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = tree[i];
            tree[i] = tree[largest];
            tree[largest] = temp;

            heapify(tree, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[] { 17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1 };
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}