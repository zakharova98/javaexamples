package org.example.classes.collections;

import org.junit.Assert;
import org.junit.Test;

public class StringExamplesTest{

    StringExamples stringExamples = new StringExamples();

    @Test
    public void testConcatenationExample() {
        String str1 = "Hello";
        String str2 = "World";
        String expected = "Hello World";
        String actual = stringExamples.concatenationExample(str1, str2);
        Assert.assertEquals(expected, actual);

        int number = 0;
        String expected2 = "Hello World 0";
        Assert.assertEquals(expected2, "Hello World " + number);
    }
}