// Программа создает объект HashMap с ключами типа Integer и значениями типа String. 
// Добавляет несколько элементов в HashMap с помощью методов putIfAbsent() и put(). 
// Выводит содержимое HashMap с помощью метода println().
// Использует цикл for-each для перебора всех элементов HashMap с помощью метода entrySet(), 
// который возвращает набор элементов в виде множества Map.Entry. 
// Для каждого элемента программа выводит ключ и значение, используя методы getKey() и getValue() объекта Map.Entry.

import java.util.*;

public class HashMapEntry {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(1, "один");
        db.put(2, "два");
        db.put(3, "три");
        System.out.println(db); 

        for (var item : db.entrySet()) {
            System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
        }
    }
}