// Программа содержит структуру для хранения гомеров паспортов и фамилий сотрудников организации:
// 123456 Иванов
// 321456 Васильев
// 234561 Петрова
// 234432 Иванов
// 654321 Петрова
// 345678 Иванов
// Через targetName выводит данные по сотрудникам с фамилией Иванов.

import java.util.HashMap;
import java.util.Map;

public class PassportName {
    public static void main(String[] args) {
        Map<Integer, String> passportData = new HashMap<>(); // LinkedHashMap гарантирует порядок, TreeMap выводит по
                                                             // возрастанию ключей
        passportData.put(123456, "Ivanov");
        passportData.put(321456, "Васильев");
        passportData.put(234561, "Петрова");
        passportData.put(234432, "Иванов");
        passportData.put(654321, "Петрова");
        passportData.put(345678, "Иванов");

        String targetName = "Иванов";
        for (int PassportNum : passportData.keySet()) {
            String name = passportData.get(PassportNum);
            if (name.equals(targetName)) {
                System.out.println(PassportNum + " " + passportData.get(PassportNum));
            }
        }
    }
}
