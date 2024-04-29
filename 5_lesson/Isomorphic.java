// Программа возвращает true или false если строки изоморфны: одну букву в первом слове можно заменить на
// некоторую букву во втором слове. При этом:
// 1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением
// порядка следования. (Например, add - egg изоморфны)
// 2. буква может не меняться, а остаться такой же. (Например, note - code)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Isomorphic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "ibm866");
        System.out.println("Введите первое слово: ");
        String word1 = scanner.nextLine();
        System.out.println("Введите второе слово: ");
        String word2 = scanner.nextLine();

        System.out.println(isIsomorphic(word1, word2)? "Слова изоморфны": "Слова не изоморфны");
        scanner.close();
    }

    public static boolean isIsomorphic(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }
        Map<Character, Character> myMap = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if (myMap.containsKey(ch1) && myMap.get(ch1) != ch2) {
                return false;
            }
            else {
                myMap.put(ch1, ch2);
            }
        }
        return true;
    }
}