// Программа демонстрирует использование HashMap в Java и основные операции с ним:
// Создается объект HashMap с ключами типа Integer и значениями типа String.
// С помощью метода putIfAbsent добавляется пара ключ-значение (1, "один") в HashMap.
// С помощью метода put добавляются пары ключ-значение (2, "два") и (null, "!null") в HashMap.
// Выводится содержимое HashMap с помощью System.out.println(db);, что показывает все добавленные элементы.
// С помощью метода get пытается получить значение по ключу 44, который отсутствует в HashMap, поэтому выводится null.
// После удаления элемента с ключом null выводится обновленное содержимое HashMap.
// С помощью метода containsValue проверяется наличие значения "один" в HashMap, что возвращает true.
// С помощью метода containsValue проверяется наличие значения 1 в HashMap, что возвращает false.
// С помощью метода containsKey проверяется наличие ключа "один" в HashMap, что возвращает false.
// С помощью метода containsKey проверяется наличие ключа 1 в HashMap, что возвращает true.
// Выводятся множество ключей и список значений HashMap с помощью keySet() и values() соответственно.

import java.util.Map;
import java.util.HashMap;
 
public class MyHashMap {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(1, "один"); 
        db.put(2, "два"); 
        db.put(null, "!null"); 
        System.out.println(db); // {null=!null, 1=один, 2=два}
        System.out.println(db.get(44));
        //db.remove(null); 
        System.out.println(db); // {1=один, 2=два}
        System.out.println(db.containsValue("один")); // true
        System.out.println(db.containsValue(1)); // false
        System.out.println(db.containsKey("один")); // false
        System.out.println(db.containsKey(1)); // true
        System.out.println(db.keySet());
        System.out.println(db.values());
    }
}