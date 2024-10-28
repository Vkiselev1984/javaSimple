//Программа проверяет является ли введенная текстовая строка числом с плавающей точкой (float).
// Программа пытается преобразовать введенную строку в число float, и если это успешно, она выводит полученное число.
// Если преобразование не удалось, программа выдаёт сообщение об ошибке "Your input is not a float number. Please, try again" и возвращает специальное значение Float.NaN, чтобы обозначить ошибку.

class IsFloat {

    public static float isFloat(String input) {
        try {
            float number = Float.parseFloat(input);
            if (Float.isInfinite(number)) {
                System.out.println("Input number is too large or too small to be represented as a float.");
                return Float.NaN;
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a float number. Please, try again.");
            return Float.NaN;
        }
    }
}

class Printer {

    public static void main(String[] args) {
        String input;
        if (args.length == 0) {
            input = "3.14";
        } else {
            input = args[0];
        }

        float result = IsFloat.isFloat(input);
        System.out.println(result);
    }
}
