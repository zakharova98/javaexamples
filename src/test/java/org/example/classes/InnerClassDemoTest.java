package org.example.classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InnerClassDemoTest {

    @Test
    public void innerClassDemoTest() {
        InnerClassDemo innerClassDemo = new InnerClassDemo();

        innerClassDemo.getOuterClass().display();

        //OuterClass outerClass = new OuterClass(); // Ошибка
        Assertions.assertEquals(100, innerClassDemo.getOuterClass().getOuter_x());
    }

}