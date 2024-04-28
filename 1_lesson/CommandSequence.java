// Программа получает числа (a, b):
// - команда 1 (к1): увеличиывает в с раза, а умножается на c
// - команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
// Программа выводит набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно

public class CommandSequence{
static String findCommandSequence(int a, int b, int c, int d) {
    if (a < 0 || b < 0 || c <= 0 || d <= 0) {
        return null;
    }

    if (a == b) {
        return "";
    }

    if (a > b || (b - a) % d != 0) {
        return null;
    }

    if (c == 1) {
        if ((b - a) % d != 0) {
            return null;
        }
        return "к2, ".repeat((b - a) / d).replaceAll(",$", "");
    }

    String command1 = findCommandSequence(a * c, b, c, d);
    if (command1 != null) {
        return "к1, " + command1;
    }

    String command2 = findCommandSequence(a + d, b, c, d);
    if (command2 != null) {
        return "к2, " + command2;
    }

    return null;
}

public static void main(String[] args) {
    int a1 = 1;
    int b1 = 7;
    int c1 = 1;
    int d1 = 3;

    String commandSequence1 = findCommandSequence(a1, b1, c1, d1);
    if (commandSequence1 != null) {
        System.out.println("Последовательность команд для a = " + a1 + " и b = " + b1 + ": " + commandSequence1);
    } else {
        System.out.println("Невозможно преобразовать число a в число b для a = " + a1 + " и b = " + b1);
    }

    int a2 = 11;
    int b2 = 7;
    int c2 = 2;
    int d2 = 1;

    String commandSequence2 = findCommandSequence(a2, b2, c2, d2);
    if (commandSequence2 != null) {
        System.out.println("Последовательность команд для a = " + a2 + " и b = " + b2 + ": " + commandSequence2);
    } else {
        System.out.println("Невозможно преобразовать число a в число b для a = " + a2 + " и b = " + b2);
    }
}
}