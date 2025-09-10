package org.example.classes.calculator;

public class Division implements CalculatorOperation {
    private double fistNumber;
    private double secondNumber;
    private double result;

    @Override
    public void performOperation() {
        if (secondNumber != 0) {
            result = fistNumber / secondNumber;
        } else throw new RuntimeException("Деление на ноль!");

    }

    // getters and setters ...
}
