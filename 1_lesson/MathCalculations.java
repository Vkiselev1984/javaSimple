// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
// (произведение чисел от 1 до n)

public class MathCalculations {
    static int calcTriangleN(int n) {
        return n * (n + 1) / 2;
    }

    static long calcFactorial(int n) {
        if (n == 0) {
            return 1;
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        int n = 5;

        int triangleNumber = calcTriangleN(n);
        System.out.println("n-е треугольное число для n = " + n + ": " + triangleNumber);

        long factorial = calcFactorial(n);
        System.out.println("Факториал n для n = " + n + ": " + factorial);
    }
}