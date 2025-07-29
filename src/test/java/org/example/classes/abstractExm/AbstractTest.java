package org.example.classes.abstractExm;

import org.junit.jupiter.api.Test;

public class AbstractTest {

    @Test
    public void testPrintMe() {
        B b = new B();
        b.printMe();
        b.printMeThere();
    }

    @Test
    public void instanseOfTest() {
        A a = new A() {
            @Override
            void printMe() {
                System.out.println("There is printMe in A class");
            }
        };

        B b = new B();
        C c = new C();
        D d = new D();

        boolean instanceOfResult = a instanceof A;
        System.out.println("a instanceof A = " + instanceOfResult);
        instanceOfResult = b instanceof A; // b extends A
        System.out.println("b instanceof A = " + instanceOfResult);
        instanceOfResult = c instanceof A; // c extends A
        System.out.println("c instanceof A = " + instanceOfResult);
        instanceOfResult = d instanceof A; // d extends B extends A
        System.out.println("d instanceof A = " + instanceOfResult);

        instanceOfResult = a instanceof Object; // all classes extends Object
        System.out.println("a instanceof Object = " + instanceOfResult);
    }
}