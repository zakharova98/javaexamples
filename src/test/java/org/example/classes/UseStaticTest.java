package org.example.classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UseStaticTest {

    @Test
    public void useStaticClassTest() {
        System.out.println("Test for UseStatic class");
        UseStatic.print();

        Assertions.assertEquals(3, UseStatic.a);
        Assertions.assertEquals(15, UseStatic.b);
    }

}