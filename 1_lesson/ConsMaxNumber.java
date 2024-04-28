// Дан массив двоичных чисел, например [], вывести
// максимальное количество подряд идущих 1.
import java.util.Arrays;

public class ConsMaxNumber {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 1,1,1, 2, 1, 0, 3, 1, 1, 1 };
        int count = 0;
        int maxCount = 0;
        System.out.println(Arrays.toString(array));
        for (int elem : array) {
            if (elem == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else
                count = 0;
        }
        System.out.println(maxCount);
    }
}