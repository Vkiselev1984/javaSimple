// Программа сортирует строки по длине с помощью TreeMap.
// Строки: "Мороз и солнце день чудесный", "Еще ты дремлешь друг прелестный", "Пора красавица проснись"

import java.util.*;

public class StringLengthComparator {
    public static void main(String[] args) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        String[] strings = {"Мороз и солнце день чудесный", "Еще ты дремлешь друг прелестный", "Пора красавица проснись"};

        for (String str : strings) {
            int length = str.length();
            if (!map.containsKey(length)) {
                map.put(length, new ArrayList<>());
            }
            map.get(length).add(str);
        }

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            for (String str : entry.getValue()) {
                System.out.println(str);
            }
        }
    }
}