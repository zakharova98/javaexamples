package org.example.types;

public class TypesExamples {

    public TypesExamples() {
    }

    public void incorrectTypesExample() {
        int i = 1;
        System.out.println(i+1);

        //i = i + "lalala"; // it's wrong - incompatible types
    }

    public void charDemo() {
        char ch1 , ch2 ;
        ch1 = 88; // code for x
        ch2 = 'У';
        System.out.println("ch1 = " + ch1 + " and ch2 = " + ch2);
    }

    public void charDemo2() {
        char ch1 = 'X';
        System.out.println("ch1 = " + ch1);

        ch1++;
        System.out.println("ch1 = " + ch1);
    }

    public void conversionDemo() {
        byte b;
        int i = 257;
        double d = 323.142;

        System.out.println( " \n int to byte" );
        b = (byte) i;
        System.out.println( "i and b : " + i + " " + b);

        System.out.println( " \n double to int" );
        i = (int) d;
        System.out.println( "d and i : " + d + " " + i );

        System.out.println ( " \n double to byte" );
        b = (byte) d;
        System.out.println ( "d and Ь : " + d + " " + b);
    }
}
