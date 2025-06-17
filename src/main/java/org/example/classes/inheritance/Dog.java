package org.example.classes.inheritance;

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
        System.out.println("The dog eats meat");
    }
}
