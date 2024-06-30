
class ComplexNumberCalculator {

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        if (num1 instanceof ConcreteComplexNumber && num2 instanceof ConcreteComplexNumber) {
            ConcreteComplexNumber cNum1 = (ConcreteComplexNumber) num1;
            ConcreteComplexNumber cNum2 = (ConcreteComplexNumber) num2;
            double real = cNum1.getReal() + cNum2.getReal();
            double imaginary = cNum1.getImaginary() + cNum2.getImaginary();
            return new ConcreteComplexNumber(real, imaginary);
        } else {
            return null;
        }
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        if (num1 instanceof ConcreteComplexNumber && num2 instanceof ConcreteComplexNumber) {
            ConcreteComplexNumber cNum1 = (ConcreteComplexNumber) num1;
            ConcreteComplexNumber cNum2 = (ConcreteComplexNumber) num2;
            double real = cNum1.getReal() * cNum2.getReal() - cNum1.getImaginary() * cNum2.getImaginary();
            double imaginary = cNum1.getReal() * cNum2.getImaginary() + cNum1.getImaginary() * cNum2.getReal();
            return new ConcreteComplexNumber(real, imaginary);
        } else {
            return null;
        }
    }

    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        if (num1 instanceof ConcreteComplexNumber && num2 instanceof ConcreteComplexNumber) {
            ConcreteComplexNumber cNum1 = (ConcreteComplexNumber) num1;
            ConcreteComplexNumber cNum2 = (ConcreteComplexNumber) num2;
            double divisor = cNum2.getReal() * cNum2.getReal() + cNum2.getImaginary() * cNum2.getImaginary();
            if (divisor == 0) {
                return null;
            }
            double real = (cNum1.getReal() * cNum2.getReal() + cNum1.getImaginary() * cNum2.getImaginary()) / divisor;
            double imaginary = (cNum2.getReal() * cNum1.getImaginary() - cNum1.getReal() * cNum2.getImaginary()) / divisor;
            return new ConcreteComplexNumber(real, imaginary);
        } else {
            return null;
        }
    }
}
