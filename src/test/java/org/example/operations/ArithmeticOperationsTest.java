package org.example.operations;

import org.junit.Assert;
import org.junit.Test;


public class ArithmeticOperationsTest {

    ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    @Test
    public void testSum() {
        int first = 10;
        int second = 5;

        int expectedSum = 15;
        int actualSum = arithmeticOperations.sum(first, second);
        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testDifference() {
        int first = 10;
        int second = 5;

        int expectedDif = 5;
        int actualDif = arithmeticOperations.difference(first, second);
        Assert.assertEquals(expectedDif, actualDif);
    }

    @Test
    public void testMultiplication() {
        int first = 10;
        int second = 5;

        int expectedMul = 50;
        int actualMul = arithmeticOperations.multiplication(first, second);
        Assert.assertEquals(expectedMul, actualMul);
    }

    @Test
    public void testDivision() {

        int first = 10;
        int second = 5;

        int expectedDiv = 2;
        int actualDiv = arithmeticOperations.division(first, second);
        Assert.assertEquals(expectedDiv, actualDiv);
    }

    @Test
    public void testMod() {
        int first = 42;
        int second = 10;

        int expectedMod = 2;
        int actualMod = arithmeticOperations.mod(first, second);
        Assert.assertEquals(expectedMod, actualMod);
    }

    @Test
    public void testDoubleMod() {
        double first = 42.25;
        double second = 10;

        double expectedMod = 2.25;
        double actualMod = arithmeticOperations.mod(first, second);
        Assert.assertEquals(expectedMod, actualMod, 0.0);
    }
}