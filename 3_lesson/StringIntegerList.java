// Создать список типа ArrayList<String>.
// Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.

import java.util.ArrayList;
import java.util.Iterator;

public class StringIntegerList {
    public static void main(String[] args) {
        ArrayList<String> mixedList = new ArrayList<>();
        mixedList.add("apple");
        mixedList.add("123");
        mixedList.add("banana");
        mixedList.add("456");
        mixedList.add("cherry");

        System.out.println("Список до удаления целых чисел:");
        System.out.println(mixedList);

        Iterator<String> iterator = mixedList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            try {
                Integer.parseInt(element); // Пытаемся преобразовать элемент в целое число
                iterator.remove(); // Если успешно, удаляем элемент из списка
            } catch (NumberFormatException e) {
                // Пропускаем элемент, если не удалось преобразовать в целое число
            }
        }

        System.out.println("Список после удаления целых чисел:");
        System.out.println(mixedList);
    }
}