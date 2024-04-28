// Программа демонстрирует алгоритм сортировки слиянием

class MergeSort {

    public static void main(String[] args) {
        // Исходный массив, который нужно отсортировать
        int[] arr = {4, 2, 7, 1, 3};

        // Вызов метода сортировки слиянием
        mergeSort(arr, 0, arr.length - 1);
        
        // Вывод отсортированного массива
        System.out.println("Отсортированный массив:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Метод сортировки слиянием
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Рекурсивный вызов для левой и правой половин массива
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // Слияние двух отсортированных подмассивов
            merge(arr, left, mid, right);
        }
    }

    // Метод слияния двух отсортированных подмассивов
    public static void merge(int[] arr, int left, int mid, int right) {
        // Вычисление размеров двух подмассивов
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Создание временных подмассивов
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Копирование данных во временные подмассивы
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Слияние временных подмассивов обратно в основной массив
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Копирование оставшихся элементов из L (если есть)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Копирование оставшихся элементов из R (если есть)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}