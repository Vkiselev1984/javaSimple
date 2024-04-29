// Программа принимает на вход пять имен пользователей (или использует имена по умолчанию, если аргументы не предоставлены) 
// и подсчитывает, сколько раз каждое имя встречается.
// Для хранения имен и их количества вхождений используется класс HashMap.
// По завершению программа выводит результат в виде пар "имя - количество".

import java.util.HashMap;

class NamesCounter {
    private HashMap<String, Integer> nameOccurrences;

    public NamesCounter() {
        nameOccurrences = new HashMap<>();
    }

    public void addName(String name) {
        nameOccurrences.put(name, nameOccurrences.getOrDefault(name, 0) + 1);
    }

    public void showNamesOccurrences() {
        System.out.println(nameOccurrences);
    }

    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;

        if (args.length == 0) {
            name1 = "Elena";
            name2 = "Elena";
            name3 = "Elena";
            name4 = "Elena";
            name5 = "Ivan";
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            name5 = args[4];
        }
        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);

        namesCounter.addName(name5);

        namesCounter.showNamesOccurrences();
    }
}