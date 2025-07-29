package org.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class CommandTest {

    @Test
    public void testGetFromString() {
        String sourceCommand = "set and push -v -a -c [5]";

        List<String> expectedParameters = new ArrayList<>();
        expectedParameters.add("v");
        expectedParameters.add("a");
        expectedParameters.add("c");
        Command expectedCommand = new Command("set and push", expectedParameters, 5);

        Command actualCommand = new Command(sourceCommand);

        Assertions.assertEquals(expectedCommand, actualCommand);
    }
}