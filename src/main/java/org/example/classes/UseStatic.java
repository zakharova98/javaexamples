package org.example.classes;

public class UseStatic {

    static int a = 3;
    static int b;

    static void print() {
        System.out.println("\nThere is print() method");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static {
        System.out.println("\nstatic block");
        b = a * 5;
    }
}
