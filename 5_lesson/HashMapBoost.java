// Программа создает три объекта HashMap с различными конфигурациями. 
// Map<Integer,String> map1 = new HashMap<>();
// Создается объект HashMap с емкостью по умолчанию.

// Map<Integer,String> map2 = new HashMap<>(30);
// Создается объект HashMap с начальной емкостью 30. Это означает, что HashMap будет
// автоматически увеличивать свою емкость при достижении определенного порога.

// Map<Integer,String> map3 = new HashMap<>(30, 0.8f);
// Создается объект HashMap с начальной емкостью 30 и коэффициентом загрузки 0.8. Коэффициент загрузки определяет, 
// когда происходит увеличение емкости HashMap при достижении определенного процента заполнения.

import java.util.*;

public class HashMapBoost {
    public static void main(String[] args) {
        // Map<Integer,String> map1 = new HashMap<>();
        // Map<Integer,String> map2 = new HashMap<>(30);
        // Map<Integer,String> map3 = new HashMap<>(30, 0.8f);

        Map<Integer, String> map = new HashMap<>(2, 0.75f); 

        System.out.println("Размер в начале: " + map.size());

        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");
        map.put(3, "Четыре");

        System.out.println("Размер после добавления 4 элемента: " + map.size());

        for (int i = 4; i <= 10; i++) {
            map.put(i, "Number " + i);
        }

        System.out.println("Размер после добавления большего количества элементов: " + map.size());
    }
}