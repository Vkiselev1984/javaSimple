// Простой калькулятор c логированием

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class CalculatorWithLogger {
    private static final Logger LOGGER = Logger.getLogger(CalculatorWithLogger.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            FileHandler fileHandler = new FileHandler("calculator.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);

            LOGGER.info("Введите первое число: ");
            double num1 = scanner.nextDouble();

            LOGGER.info("Введите операцию (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            LOGGER.info("Введите второе число: ");
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
                        LOGGER.severe("Ошибка: деление на ноль!");
                        return;
                    }
                    break;
                default:
                    LOGGER.severe("Ошибка: некорректная операция!");
                    return;
            }

            LOGGER.info("Результат: " + result);
        } catch (Exception e) {
            LOGGER.severe("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}