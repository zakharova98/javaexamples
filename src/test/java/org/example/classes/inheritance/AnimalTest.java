package org.example.classes.inheritance;

import org.example.classes.Box;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AnimalTest {

    @Test
    public void creationTest() {
        Dog dog = new Dog();

        dog.bark();
        dog.eat(); // наследованный метод от класса Animal
        Assertions.assertEquals(0, dog.getAge());
        Assertions.assertNull(dog.getBreed());
        Assertions.assertNull(dog.getName());
        Assertions.assertNull(dog.getColor());
        Assertions.assertEquals(0, dog.getWeight());

        System.out.println("\n");

        Dog dogOllie = new Dog("gray", 5, 15, "Ollie", "Collie");
        dogOllie.bark();
        dogOllie.eat();

        Assertions.assertEquals(5, dogOllie.getAge());
        Assertions.assertEquals("Collie", dogOllie.getBreed());
        Assertions.assertEquals("Ollie", dogOllie.getName());
        Assertions.assertEquals("gray", dogOllie.getColor());
        Assertions.assertEquals(15, dogOllie.getWeight());

    }

}