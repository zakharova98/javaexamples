package org.example.operations;

import junit.framework.TestCase;
import org.junit.Assert;

public class BooleanOperationsTest extends TestCase {

    BooleanOperations booleanOperations = new BooleanOperations();

    // Возвращает true если оба операнда равны true
    public void testAndOperation() {
        boolean first = true;
        boolean second = true;

        boolean expected = true;
        boolean actual = booleanOperations.andOperation(first, second);
        Assert.assertEquals(expected, actual);

        second = false;
        expected = false;
        actual = booleanOperations.andOperation(first, second);
        Assert.assertEquals(expected, actual);

        first = false;
        expected = false;
        actual = booleanOperations.andOperation(first, second);
        Assert.assertEquals(expected, actual);
    }

    // Возвращает true если хотя бы один из операндов равен true
    public void testOrOperation() {
        boolean first = true;
        boolean second = true;

        boolean expected = true;
        boolean actual = booleanOperations.orOperation(first, second);
        Assert.assertEquals(expected, actual);

        second = false;
        expected = true;
        actual = booleanOperations.orOperation(first, second);
        Assert.assertEquals(expected, actual);

        first = false;
        expected = false;
        actual = booleanOperations.orOperation(first, second);
        Assert.assertEquals(expected, actual);
    }

    // если оператор слева является true, оператор возвращает true без проверки второго операнда
    public void testXorOperation() {
        boolean first = true;
        boolean second = true;

        boolean expected = true;
        boolean actual = booleanOperations.xorOperation(first, second);
        Assert.assertEquals(expected, actual);

        second = false;
        expected = true;
        actual = booleanOperations.xorOperation(first, second);
        Assert.assertEquals(expected, actual);


        first = false;
        expected = false;
        actual = booleanOperations.xorOperation(first, second);
        Assert.assertEquals(expected, actual);
    }

    // возвращает true если операнд является false. Возвращает false если операнд является true.
    public void testNotOperation() {
        boolean value = true;

        boolean actual = booleanOperations.notOperation(value);
        Assert.assertEquals(false, actual);

        value = false;
        actual = booleanOperations.notOperation(value);
        Assert.assertEquals(true, actual);
    }
}