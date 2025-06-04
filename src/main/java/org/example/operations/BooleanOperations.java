package org.example.operations;

public class BooleanOperations {

    public BooleanOperations() {
    }

    public boolean andOperation(boolean first, boolean second) {

        System.out.println("\nAnd operation. First is: " + first + ", Second is: " + second);
        boolean result = first & second;
        System.out.println("result = " + result);

        return result;
    }

    public boolean orOperation(boolean first, boolean second) {
        System.out.println("\nOr operation. First is: " + first + ", Second is: " + second);
        boolean result = first | second;
        System.out.println("result = " + result);

        return result;
    }

    public boolean xorOperation(boolean first, boolean second) {
        System.out.println("\nXor operation. First is: " + first + ", Second is: " + second);
        boolean result = first || second;
        System.out.println("result = " + result);

        return result;
    }

    public boolean notOperation(boolean value) {
        System.out.println("\nNot operation. Value is: " + value);
        boolean result = !value;
        System.out.println("result = " + result);

        return result;
    }
}
