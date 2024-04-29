// Программа переводит целое число в римский формат.
// 1000, "M"
// 900, "CM"
// 500, "D"
// 400, "CD"
// 100, "C"
// 90, "XC"
// 50, "L"
// 40, "XL"
// 10, "X"
// 9, "IX"
// 5, "V"
// 4, "IV"
// 1, "I"

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanFromArabic {
    public static void main(String[] args) {
        int arabicNumber = 2024;
        System.out.println(arabicNumber + " -> " + getRomanFromArabic(arabicNumber));
    }

    public static Map<Integer, String> getArabicRomanMap() {
        Map<Integer, String> arabicRomanMap = new LinkedHashMap<>();
        arabicRomanMap.put(1000, "M");
        arabicRomanMap.put(900, "CM");
        arabicRomanMap.put(500, "D");
        arabicRomanMap.put(400, "CD");
        arabicRomanMap.put(100, "C");
        arabicRomanMap.put(90, "XC");
        arabicRomanMap.put(50, "L");
        arabicRomanMap.put(40, "XL");
        arabicRomanMap.put(10, "X");
        arabicRomanMap.put(9, "IX");
        arabicRomanMap.put(5, "V");
        arabicRomanMap.put(4, "IV");
        arabicRomanMap.put(1, "I");
        return arabicRomanMap;
    }

    public static String getRomanFromArabic(int arabicNumber) {
        Map<Integer, String> arabicRomanMap = getArabicRomanMap();
        StringBuilder sb = new StringBuilder();
        for (int key : arabicRomanMap.keySet()) {
            while (arabicNumber >= key) {
                sb.append(arabicRomanMap.get(key));
                arabicNumber -= key;
            }
        }
        return sb.toString();
    }
}