// Программа возводит числа а в степень b. a, b из Z.
// Сводя количество выполняемых действий к минимуму.
// Пример 1: а = 3, b = 2, ответ: 9
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1

public class PowerCalculation {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        
        double result = Math.pow(a, b);
        System.out.println("Ответ: " + result);
        
        a = 2;
        b = -2;
        result = Math.pow(a, b);
        System.out.println("Ответ: " + result);
        
        a = 3;
        b = 0;
        result = Math.pow(a, b);
        System.out.println("Ответ: " + result);
    }
}