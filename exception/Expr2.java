
class Expr2 {

    public static double expr(int a, int b) {
        double result = 0.0; // Initialize the result
        if (b != 0) {
            result = (double) a / b; // Perform the division and store the result
        }
        printSum(a, b);
        return result; // Return the result
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}

class Printer {

    public static void main(String[] args) {
        int a;
        int b;

        if (args.length == 0) {
            a = 90;
            b = 3; // Default values if no arguments are provided
        } else {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }

        double result = Expr2.expr(a, b);
        System.out.println(result);
    }
}
