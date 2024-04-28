// Программа сжимает строку.
// Пример: вход aaaabbbcdd.

public class StringCompression {
    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder compressed = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar);
                if (count > 1) {
                    compressed.append(count);
                }
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        compressed.append(currentChar);
        if (count > 1) {
            compressed.append(count);
        }

        return compressed.toString();
    }

    public static void main(String[] args) {
        String input = "aaaabbbcdd";
        String compressedString = compressString(input);
        System.out.println(compressedString);
    }
}