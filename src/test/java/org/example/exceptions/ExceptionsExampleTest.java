package org.example.exceptions;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExceptionsExampleTest  {

    public ExceptionsExample exceptionsExample = new ExceptionsExample();

    @Test
    public void notCaughtExceptionTest() {
        exceptionsExample.caughtException(); // здесь не будет исключения
    }

    @Test
    public void testNestedCaughtException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            exceptionsExample.nestedCaughtException(0);
        });

        System.out.println();
        Assertions.assertDoesNotThrow(() -> {
            exceptionsExample.nestedCaughtException(5);
        });
    }

    @Test
    // exceptionsExample.throwExceptionExample выбрасывает исключения на нечетные значения
    public void testThrowExceptionExample() {

        Assertions.assertThrows(Exception.class, () -> {
            exceptionsExample.throwExceptionExample(201);
        });

        Assertions.assertDoesNotThrow(() -> {
            exceptionsExample.throwExceptionExample(200);
        });
    }

    @Test
    public void testUncheckedExceptionExample() {
        Assertions.assertDoesNotThrow(() -> {
            exceptionsExample.uncheckedExceptionExample(1);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            exceptionsExample.uncheckedExceptionExample(200);
        });
    }

    @Test
    public void testMyExceptionExample() {

        Assertions.assertThrows(MyException.class, () -> {
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