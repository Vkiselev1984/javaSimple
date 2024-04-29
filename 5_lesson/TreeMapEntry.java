// Программа создает объект TreeMap, который хранит пары ключ-значение, 
// где ключи - целые числа, а значения - строки. 
// Затем она добавляет несколько элементов в TreeMap с различными ключами и значениями, 
// и выводит TreeMap после каждого добавления. TreeMap автоматически сортирует элементы по ключу в возрастающем порядке.
// После выполнения программы, каждый вывод содержит текущее состояние TreeMap, где ключи отсортированы по возрастанию.

import java.util.TreeMap;

public class TreeMapEntry {
    public static void main(String[] args) {
        TreeMap<Integer,String> tMap = new TreeMap<>();
        tMap.put(1,"один"); System.out.println(tMap); 
        // {1=один}
        tMap.put(6,"шесть"); System.out.println(tMap);
        // {1=один, 6=шесть}
        tMap.put(4,"четыре"); System.out.println(tMap);
        // {1=один, 4=четыре, 6=шесть}
        tMap.put(3,"три"); System.out.println(tMap);
        // {1=один, 3=три, 4=четыре, 6=шесть}
        tMap.put(2,"два"); System.out.println(tMap);
        // {1=один, 2=два, 3=три, 4=четыре, 6=шесть}
    }
}
