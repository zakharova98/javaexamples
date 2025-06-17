package org.example.classes;

import org.junit.Assert;
import org.junit.Test;

public class InnerClassDemoTest {

    @Test
    public void innerClassDemoTest() {
        InnerClassDemo innerClassDemo = new InnerClassDemo();

        innerClassDemo.getOuterClass().display();

        //OuterClass outerClass = new OuterClass(); // Ошибка
        Assert.assertEquals(100, innerClassDemo.getOuterClass().getOuter_x());
    }

}