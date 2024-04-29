// Программа преобразует римское число в арабское число. 

// В методе getMapRomanArabic() создается и заполняется Map romanArabicMap, 
// где ключами являются символы римских цифр (I, V, X, L, C, D, M), 
// а значениями - их эквиваленты в арабских цифрах (1, 5, 10, 50, 100, 500, 1000).

// В методе getArabicFromRoman(String romanValue) происходит преобразование римского числа в арабское число:
// Получается Map romanArabicMap с помощью метода getMapRomanArabic().
// Инициализируются переменные result (итоговое арабское число) и prev (предыдущее значение).
// Проход по римскому числу romanValue справа налево.
// Для каждого символа римской цифры получается его арабское значение из romanArabicMap.
// Если текущее значение меньше предыдущего, то вычитается из result, иначе прибавляется.
// Обновляется значение prev на текущее значение.
// В конце возвращается итоговое арабское число.
// В методе main создается строка roman с римским числом "MMMDCCLVI", которое соответствует числу 3756.

import java.util.HashMap;
import java.util.Map;

public class ArabicFromRoman {
    public static void main(String[] args) {
        String roman = "MMMDCCLVI";
        System.out.println(getArabicFromRoman(roman));

    }
    public static Map<Character, Integer> getMapRomanArabic() {
        Map<Character, Integer> romanArabicMap = new HashMap<>();
        romanArabicMap.put('I', 1);
        romanArabicMap.put('V', 5);
        romanArabicMap.put('X', 10);
        romanArabicMap.put('L', 50);
        romanArabicMap.put('C', 100);
        romanArabicMap.put('D', 500);
        romanArabicMap.put( 'M', 1000);
        return romanArabicMap;
    }
    public static int getArabicFromRoman(String romanValue) {
        Map<Character, Integer> romanArabicMap = getMapRomanArabic();
        int result = 0;
        int prev = 0;
        for (int i = romanValue.length() - 1 ; i >= 0; i--) {
            int num = romanArabicMap.get(romanValue.charAt(i));
            if(num < prev){
                result -= num;
            } else{
                result += num;
            }
            prev = num;
        }
        return result;
    }
}