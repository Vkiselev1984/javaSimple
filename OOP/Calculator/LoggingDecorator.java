
class LoggingDecorator {

    private final ComplexNumberCalculator calculator;

    public LoggingDecorator(ComplexNumberCalculator calculator) {
        this.calculator = calculator;
    }

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = calculator.add(num1, num2);
        System.out.println("Sum " + num1 + " and " + num2 + " = " + result);
        return result;
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = calculator.multiply(num1, num2);
        System.out.println("Multiplying " + num1 + " and " + num2 + " = " + result);
        return result;
    }

    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = calculator.divide(num1, num2);
        System.out.println("Dividing " + num1 + " by " + num2 + " = " + result);
        return result;
    }
}
