
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.Scanner;

// Пользовательское исключение для обработки ошибок ввода
class UserInputException extends Exception {

    public UserInputException(String message) {
        super(message);
    }
}

public class UserInfoApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Запрос данных у пользователя
                String surname = promptUser(scanner, "Введите фамилию:");
                String name = promptUser(scanner, "Введите имя:");
                String middleName = promptUser(scanner, "Введите отчество:");
                int age = Integer.parseInt(promptUser(scanner, "Введите возраст:"));
                LocalDate dateOfBirth = calculateDateOfBirth(age);
                long phoneNumber = parsePhoneNumber(promptUser(scanner, "Введите номер телефона:"));
                char gender = parseGender(promptUser(scanner, "Введите пол (f/m):"));

                // Запись данных в файл
                writeToFile(surname, name, middleName, dateOfBirth, phoneNumber, gender);
                System.out.println("Данные успешно сохранены.");
                break; // Выход из цикла при успешном завершении
            } catch (UserInputException e) {
                System.err.println("Ошибка ввода: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: Вводите целое число для возраста.");
            }
        }

        scanner.close(); // Закрытие сканера
    }

    // Метод для запроса данных у пользователя
    private static String promptUser(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }

    // Метод для вычисления даты рождения на основе возраста
    private static LocalDate calculateDateOfBirth(int age) throws UserInputException {
        if (age < 0) {
            throw new UserInputException("Возраст не может быть отрицательным.");
        }
        return LocalDate.now().minusYears(age);
    }

    private static long parsePhoneNumber(String phoneNumberStr) throws UserInputException {
        try {
            return Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            throw new UserInputException("Неверный формат номера телефона.");
        }
    }

    private static char parseGender(String genderStr) throws UserInputException {
        if (genderStr.length() != 1 || !(genderStr.equalsIgnoreCase("f") || genderStr.equalsIgnoreCase("m"))) {
            throw new UserInputException("Неверный пол. Ожидалось 'f' или 'm'.");
        }
        return genderStr.toLowerCase().charAt(0);
    }

    private static void writeToFile(String surname, String name, String middleName, LocalDate dateOfBirth,
            long phoneNumber, char gender) throws IOException {
        String filename = surname + ".txt"; // Формирование имени файла
        String line = String.format("%s %s %s %s %d %c", surname, name, middleName, dateOfBirth, phoneNumber, gender);

        // Запись строки в файл с использованием UTF-8
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, true), "UTF-8"))) {
            writer.write(line);
            writer.newLine(); // Переход на новую строку
        }
    }
}
