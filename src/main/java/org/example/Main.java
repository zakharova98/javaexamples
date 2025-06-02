package org.example;


import org.example.types.ArraysExample;
import org.example.types.TypesExamples;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello and welcome!\n");

        TypesExamples typesExamples = new TypesExamples();
        //typesExamples.incorrectTypesExample();
        //typesExamples.charDemo();
        //typesExamples.charDemo2();
        //typesExamples.conversionDemo();

        ArraysExample arraysExample = new ArraysExample();
        //arraysExample.initArrays();
        //arraysExample.initMdArray();
        //arraysExample.initMdArray2();
        System.out.println("Incorrect copy array");
        arraysExample.copyArrayIncorrectly();

        System.out.println("\nCorrect copy array");
        arraysExample.copyArrayCorrectly();
    }


}