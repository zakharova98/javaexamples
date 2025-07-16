package org.example.exceptions;


import org.junit.Assert;
import org.junit.Test;

public class ExceptionsExampleTest  {

    public ExceptionsExample exceptionsExample = new ExceptionsExample();

    @Test
    public void notCaughtExceptionTest() {
        exceptionsExample.caughtException(); // здесь не будет исключения
    }

    @Test
    public void testNestedCaughtException() {
        Assert.assertThrows(ArithmeticException.class, () -> {
            exceptionsExample.nestedCaughtException(0);
        });

        System.out.println();
        exceptionsExample.nestedCaughtException(5); // здесь не будет исключения
    }

    @Test
    public void testThrowExceptionExample() throws Exception {
        Assert.assertThrows(Exception.class, () -> {
            exceptionsExample.throwExceptionExample(201);
        });

        exceptionsExample.throwExceptionExample(200); // здесь не будет исключения
    }

    @Test
    public void testUncheckedExceptionExample() {
        exceptionsExample.uncheckedExceptionExample(1);

        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            exceptionsExample.uncheckedExceptionExample(200);
        });
    }

    @Test
    public void testMyExceptionExample() {

        Assert.assertThrows(MyException.class, () -> {
            exceptionsExample.myExceptionExample(200);
        });

        try {
            exceptionsExample.myExceptionExample(10);
            exceptionsExample.myExceptionExample(300);
        } catch (MyException e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void testCausedExceptionExample() {

        try {
            exceptionsExample.causedExceptionExample();
        } catch (MyException exception) {
            System.out.println("Exception: " + exception);

            System.out.println("Caused by: " + exception.getCause()); // может быть null
        }
    }
}