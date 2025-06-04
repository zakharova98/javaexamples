package org.example.operations;

public class BitwiseOperations {

    public BitwiseOperations() {
    }

    // побитовое НЕ
    public int bitwiseComplement(int number) {
        System.out.println("Bitwise complement. Number = " + number + " (" + Integer.toBinaryString(number) + ")");

        int temp = ~number;
        System.out.println("~number = " + temp + " (" + Integer.toBinaryString(temp) + ")");
        return temp;
    }

    // побитовое И
    public int bitwiseAnd(int first, int second) {
        System.out.println("Bitwise complement. First = " + first + " (" + Integer.toBinaryString(first) + ")"
                + ", second = " + second + " (" + Integer.toBinaryString(second) + ")");

        int temp = first & second;
        System.out.println("result is: " + temp + " (" + Integer.toBinaryString(temp) + ")");
        return temp;
    }

    // побитовое ИЛИ
    public int bitwiseOr(int first, int second) {
        System.out.println("Bitwise or. First = " + first + " (" + Integer.toBinaryString(first) + ")"
                + ", second = " + second + " (" + Integer.toBinaryString(second) + ")");

        int temp = first | second;
        System.out.println("result is: " + temp + " (" + Integer.toBinaryString(temp) + ")");
        return temp;
    }

    // побитовое исключающее ИЛИ
    public int bitwiseXor(int first, int second) {
        System.out.println("Bitwise xor. First = " + first + " (" + Integer.toBinaryString(first) + ")"
                + ", second = " + second + " (" + Integer.toBinaryString(second) + ")");

        int temp = first ^ second;
        System.out.println("result is: " + temp + " (" + Integer.toBinaryString(temp) + ")");
        return temp;
    }

    // сдвиг влево
    public int bitwiseShiftLeft(int first, int second) {
        System.out.println("Bitwise shift left. First = " + first + " (" + Integer.toBinaryString(first) + ")"
                + ", second = " + second + " (" + Integer.toBinaryString(second) + ")");

        int temp = first << second;
        System.out.println("result is: " + temp + " (" + Integer.toBinaryString(temp) + ")");
        return temp;
    }

    // сдвиг вправо
    public int bitwiseShiftRight(int first, int second) {
        System.out.println("Bitwise shift right. First = " + first + " (" + Integer.toBinaryString(first) + ")"
                + ", second = " + second + " (" + Integer.toBinaryString(second) + ")");

        int temp = first >> second;
        System.out.println("result is: " + temp + " (" + Integer.toBinaryString(temp) + ")");
        return temp;
    }

    // сдвиг вправо с заполнением нулями
    public int bitwiseShiftRightWithNull(int first, int second) {
        System.out.println("Bitwise shift right with nulls. First = " + first + " (" + Integer.toBinaryString(first) + ")"
                + ", second = " + second + " (" + Integer.toBinaryString(second) + ")");

        int temp = first >>> second;
        System.out.println("result is: " + temp + " (" + Integer.toBinaryString(temp) + ")");
        return temp;
    }

}
