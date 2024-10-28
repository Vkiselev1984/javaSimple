
import java.util.Scanner;

public class PhoneBookApp {

    // Класс исключения для неверного формата даты рождения
    static class InvalidDateOfBirthFormatException extends Exception {

        public InvalidDateOfBirthFormatException(String message) {
            super(message);
        }
    }

    // Класс исключения для неверного формата номера телефона
    static class InvalidPhoneNumberFormatException extends Exception {

        public InvalidPhoneNumberFormatException(String message) {
            super(message);
        }
    }

    // Класс исключения для неверного формата пола
    static class InvalidGenderFormatException extends Exception {

        public InvalidGenderFormatException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine();

        // Далее будем обрабатывать введенные данные
    }
}
