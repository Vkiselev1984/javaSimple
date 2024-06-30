# Сalculator of complex numbers

The project of a calculator of complex numbers with the operations of addition, multiplication and division and the use of architectural patterns, and logging.

## How it work:

- A ComplexNumberFactory is created to create complex numbers. For the example, two numbers num1 and num2 are created;
- A ComplexNumberCalculator is created that contains methods to perform operations on complex numbers: addition, multiplication, and division;
- A LoggingDecorator is created that wraps the calculator and adds logging operations;
- The main method performs operations on complex numbers with logging of the results.

## Principles used in this code:

- Single responsibility principle: each class is responsible for a specific functionality;
- The principle of openness/closedness: the code can be easily extended and modified by using interfaces and decorators;
- Barbara Liskov's substitution principle: the ConcreteComplexNumber and ConcreteComplexNumberFactory classes can be used instead of the ComplexNumber and ComplexNumberFactory interfaces.

## The patterns used in this code are:

- Decorator (Decorator): LoggingDecorator adds logging functionality to the ComplexNumberCalculator object;
- Factory Method: ConcreteComplexNumberFactory creates instances of the ConcreteComplexNumber class.
