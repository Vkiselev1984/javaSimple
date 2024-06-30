
class ConcreteComplexNumber implements ComplexNumber {

    private final double real;
    private final double imaginary;

    public ConcreteComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }
}
