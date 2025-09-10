package org.example.classes.interfaces;

import org.junit.jupiter.api.Test;

class SomeClassTest {

    @Test
    void testValues() {
        SomeClass someClass = new SomeClass();

        System.out.println("NO value = " + someClass.NO);
        System.out.println("NEVER value = " + someClass.NEVER);

        System.out.println("YES value = " + someClass.YES);
    }
}