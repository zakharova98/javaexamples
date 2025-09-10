package org.example.classes.calculator;

public class Subtraction implements CalculatorOperation {
    private double firstNumber;
    private double secondNumber;
    private double result = 0.0;

    public Subtraction(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public void performOperation() {
        result = firstNumber - secondNumber;
    }

    // getters and setters

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
