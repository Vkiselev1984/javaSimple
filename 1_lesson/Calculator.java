// Простой калькулятор

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введите операцию (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Ошибка: деление на ноль!");
                        return;
                    }
                    break;
                default:
                    System.out.println("Ошибка: некорректная операция!");
                    return;
            }

            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}