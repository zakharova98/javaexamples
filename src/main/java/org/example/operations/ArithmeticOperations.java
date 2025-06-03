package org.example.operations;

public class ArithmeticOperations {

    public ArithmeticOperations() {
    }

    public void demonstrateOperation(int first, int second) {
        System.out.println("demonstrate operation. First number is: " + first + ", second number is: " + second);

        System.out.println("The sum is: " + sum(first, second));

        System.out.println("The difference is: " + difference(first, second));

        System.out.println("The multiplication is: " + multiplication(first, second));

        System.out.println("The division is: " + division(first, second));

        System.out.println("The mod is: " + mod(first, second));
        System.out.println("The double mod is: " + mod((double)first, (double)second));

    }

    public int sum(int first, int second) {
        return first + second;
    }

    public int difference(int first, int second) {
        return first - second;
    }

    public int multiplication(int first, int second) {
        return first * second;
    }

    public int division(int first, int second) {
        return first / second;
    }

    public int mod(int first, int second) {
        return first % second;
    }

    public double mod(double first, double second) {
        return (double) first % second;
    }

    public void demonstrateIncrementOperation(int number) {
        System.out.println("\ndemonstrateIncrementOperation");
        int a = number;

        // префиксный инкремент
        int b = ++a; // вначале значение переменной a увеличивается на 1, а затем ее значение присваивается переменной b
        System.out.println("a = " + a + ", b = " + b);

        // постфиксный инкремент
        int c = b++; // вначале значение переменной c присваивается переменной b, а потом значение переменной b увеличивается на 1
        System.out.println("c = " + c + ", b = " + b);

    }

    public void demonstrateDecrementOperation(int number) {
        System.out.println("\ndemonstrateDecrementOperation");

        int a = number;
        // префиксный декремент
        int b = --a; // вначале значение переменной a уменьшается на 1, а потом ее значение присваивается переменной b
        System.out.println("a = " + a + ", b = " + b);

        // постфиксный инкремент
        int c = b--; // вначале значение переменной c присваивается переменной b, а потом значение переменной b уменьшается на 1
        System.out.println("c = " + c + ", b = " + b);
    }
}
