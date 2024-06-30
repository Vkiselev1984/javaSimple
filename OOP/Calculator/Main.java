
public class Main {

    public static void main(String[] args) {
        // Creating a complex number factory
        ComplexNumberFactory factory = new ConcreteComplexNumberFactory();
        // Creating complex numbers
        ComplexNumber num1 = factory.createComplexNumber(2, 3);
        ComplexNumber num2 = factory.createComplexNumber(1, -1);
        // Creating a complex number calculator
        ComplexNumberCalculator calculator = new ComplexNumberCalculator();
        // Decorator for logging operations
        LoggingDecorator loggingDecorator = new LoggingDecorator(calculator);
        // Performing operations with complex numbers
        loggingDecorator.add(num1, num2);
        loggingDecorator.multiply(num1, num2);
        loggingDecorator.divide(num1, num2);
    }
}
