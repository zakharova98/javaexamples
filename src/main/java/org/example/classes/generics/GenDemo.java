package org.example.classes.generics;

public class GenDemo {

    public void genericsDemo() {

        // для объектов типа Integer
        Gen<Integer> objGenInt;
        objGenInt = new Gen<Integer>(88);
        objGenInt.showType();
        int value = objGenInt.getValue();
        System.out.println("value is " + value);

        System.out.println();

        // для объекто типа String
        Gen<String> objGenString;
        objGenString = new Gen<String>("Some value");
        objGenString.showType();
        String valueString = objGenString.getValue();
        System.out.println("value is " + valueString);

    }



}
