// Дано четное число N (>0) и символы c1 и c2.
// Программа возвращает строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.


public class AlternateCharacters {
    public static String generateString(int N, char c1, char c2) {
        StringBuilder sb = new StringBuilder();
        char currentChar = c1;

        for (int i = 0; i < N; i++) {
            sb.append(currentChar);
            currentChar = (currentChar == c1) ? c2 : c1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int N = 10;
        char c1 = 'A';
        char c2 = 'B';

        String result = generateString(N, c1, c2);
        System.out.println(result);
    }
}
