// Дан массив nums = [] и число val = 2.
// Если в массиве есть числа, равные заданному, программа переносит
// эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива
// должны быть отличны от заданного, а остальные - равны ему

import java.util.Arrays;

public class MoveValToEnd {
    public static void main(String[] args) {
        int[] elements = new int[] { 3, 2, 2, 3, 4, 6, 3 };
        int val = 2;
        int rightIndex = elements.length - 1;
        moveValToEnd(elements, val, rightIndex);
        System.out.println(Arrays.toString(elements));
    }

    private static void moveValToEnd(int[] elements, int val, int rightIndex) {
        for (int leftIndex = 0; leftIndex < rightIndex; leftIndex++) {
            while (elements[rightIndex] == val && leftIndex<rightIndex) {
                rightIndex--;
            }
            if (elements[leftIndex] == val) {
                elements[leftIndex] = elements[rightIndex];
                elements[rightIndex] = val;
            }

        }
    }
}
