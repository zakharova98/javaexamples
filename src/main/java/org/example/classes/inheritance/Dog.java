package org.example.classes.inheritance;

import org.example.exceptions.MyException;

public class Dog extends Animal {

    private String name;
    private String breed;

    public Dog() {
    }

    public Dog(String color, int age, int weight, String name, String breed) {
        super(color, age, weight); // вызвать конструктор суперкласса
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void bark() {
        System.out.println("The dog barks");
    }

    @Override
    public void eat() {
        if (this.name != null && !this.name.isEmpty()) {
            System.out.println("The dog " + this.name + " eats meat");
        } else {
            System.out.println("The dog eats meat");
        }
    }

    @Override
    public void sleep() throws MyException{
        if (this.breed == "Non sleeping dog") {
            System.out.println("this dog doesn't sleep!");
            throw new MyException();
        } else {
            System.out.println("this dog is sleeping zzzz");
        }
    }
}
