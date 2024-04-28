// Программа принимает на вход строку (String) и
// определяет является ли строка палиндромом (возвращает boolean значение).

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "radar";
        boolean isPalindrome = isPalindrome(input);
        
        if (isPalindrome) {
            System.out.println("Строка является палиндромом");
        } else {
            System.out.println("Строка не является палиндромом");
        }
    }
}