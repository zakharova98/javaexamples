package org.example;


import org.example.operations.ArithmeticOperations;
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
        //System.out.println("Incorrect copy array");
        //arraysExample.copyArrayIncorrectly();

        //System.out.println("\nCorrect copy array");
        //arraysExample.copyArrayCorrectly();

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        //arithmeticOperations.demonstrateOperation(30, 13);
        //arithmeticOperations.demonstrateIncrementOperation(10);
        //arithmeticOperations.demonstrateDecrementOperation(55);

        Operators operators = new Operators();
        //operators.ifOperatorExample();
        //operators.switchOperatorExample(2);
        //operators.switchOperatorExampleMonth(7);
        //operators.whileOperatorExample();
        //operators.doWhileOperatorExample();
        //operators.forOperatorExample();
        //System.out.println("----");
        //operators.forOperatorExample2();
        //operators.forEachOperatorExample();
        //operators.forOperatorExampleForArray();
        //operators.breakOperatorExample();
        //operators.breakOperatorGoToExample();
        //operators.continueOperatorForExample();
        //operators.continueOperatorWhileExample();
        //operators.continueOperatorGoToExample();
        operators.returnOperatorExample();



    }


}