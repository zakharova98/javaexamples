package org.example.classes;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class UseStaticTest extends TestCase {

    @Test
    public void useStaticClassTest() {
        System.out.println("Test for UseStatic class");
        UseStatic.print();

        Assert.assertEquals(3, UseStatic.a);
        Assert.assertEquals(15, UseStatic.b);
    }

}