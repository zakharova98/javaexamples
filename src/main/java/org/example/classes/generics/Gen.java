package org.example.classes.generics;

public class Gen<T> {

    private T value;

    public Gen(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    void showType() {
        System.out.println("Type of T is: " + value.getClass().getName());
    }
}
