package org.example.classes;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class BoxTest {

    @Test
    @Ignore
    public void badCreationExampleTest() {
        /*Box box = new Box();
        box.height = 15;
        box.width = 2;
        box.depth = 4;
        double vol = box.height * box.width * box.depth;

        System.out.println("vol = " + vol);*/
    }

    @Test
    public void creationExampleTest() {
        Box box = new Box(15, 2, 4);
        double vol = box.getVolume();

        Assert.assertEquals(120, vol, 0.0);
    }

    @Test
    public void creationExampleTest2() {
        Box box = new Box();
        Assert.assertEquals(0, box.getWidth(), 0.0);
        Assert.assertEquals(0, box.getHeight(), 0.0);
        Assert.assertEquals(0, box.getDepth(), 0.0);

        Box cube = new Box(3);
        Assert.assertEquals(3, cube.getWidth(), 0.0);
        Assert.assertEquals(3, cube.getHeight(), 0.0);
        Assert.assertEquals(3, cube.getDepth(), 0.0);
        Assert.assertEquals(27, cube.getVolume(), 0.0);
    }

    @Test
    public void creationExampleTest3() {
        Box box = new Box();
        //box.width = 15; // нельзя инициализировать private поле
        box.setWidth(15);

        box.name = "First Box";
        System.out.println(box);
    }

    @Test
    public void linksExampleTest() {
        Box box1 = new Box(15, 2, 4);
        Box box2 = box1; // это не ссылка на копию, box1 и box2 ссылаются на один и тот же объект

        Assert.assertEquals(15, box2.getWidth(), 0.0);

        box1.setWidth(30);
        Assert.assertNotEquals(15, box2.getWidth(), 0.0);
        Assert.assertEquals(30, box2.getWidth(), 0.0);

    }

}