package org.example.testing;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.classes.Box;
import org.junit.Assert;

public class BoxCucumber {

    Box box;

    @Given("create box with width {int} and height {int} and depth {int}")
    public void create_box(int width, int height, int depth) {
        box = new Box(width, height, depth);
    }
    @When("I get volume {double}")
    public void get_volume(double volume) {
        System.out.println("[DEBUG] volume = " + box.getVolume());
        Assert.assertEquals(volume, box.getVolume(), 0);
    }
}
