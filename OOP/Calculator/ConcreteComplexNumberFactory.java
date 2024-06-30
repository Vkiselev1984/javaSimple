
class ConcreteComplexNumberFactory implements ComplexNumberFactory {

    @Override
    public ComplexNumber createComplexNumber(double real, double imaginary) {
        return new ConcreteComplexNumber(real, imaginary);
    }
}
