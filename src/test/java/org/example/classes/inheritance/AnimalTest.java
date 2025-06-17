package org.example.classes.inheritance;

import org.example.classes.Box;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void creationTest() {
        Dog dog = new Dog();

        dog.bark();
        dog.eat(); // наследованный метод от класса Animal
        Assert.assertEquals(0, dog.getAge());
        Assert.assertNull(dog.getBreed());
        Assert.assertNull(dog.getName());
        Assert.assertNull(dog.getColor());
        Assert.assertEquals(0, dog.getWeight());

        System.out.println("\n");

        Dog dogOllie = new Dog("gray", 5, 15, "Ollie", "Collie");
        dogOllie.bark();
        dogOllie.eat();

        Assert.assertEquals(5, dogOllie.getAge());
        Assert.assertEquals("Collie", dogOllie.getBreed());
        Assert.assertEquals("Ollie", dogOllie.getName());
        Assert.assertEquals("gray", dogOllie.getColor());
        Assert.assertEquals(15, dogOllie.getWeight());

    }

}