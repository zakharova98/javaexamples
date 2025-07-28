package org.example;


import org.example.classes.generics.GenDemo;
import org.example.collections.IteratorExample;
import org.example.collections.CollectionsExamples;
import org.example.collections.StringExamples;
import org.example.io.IOExamples;
import org.example.operations.ArithmeticOperations;
import org.example.types.ArraysExample;
import org.example.types.TypesExamples;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
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
        //operators.returnOperatorExample();

        StringExamples stringExamples = new StringExamples();
        //stringExamples.creationExample();
        //stringExamples.equalsExample();
        //stringExamples.compareToExample();
        //stringExamples.searchExample();
        //stringExamples.modificationExample();
        //stringExamples.stringBuilderExample();

        IteratorExample iteratorExample = new IteratorExample();
        //iteratorExample.iteratorDemo();

        CollectionsExamples collectionsExamples = new CollectionsExamples();
        //collectionsExamples.arrayListDemo();
        //collectionsExamples.linkedListDemo();
        //collectionsExamples.hashSetDemo();
        //collectionsExamples.linkedHashSetDemo();
        //collectionsExamples.treeSetDemo();
        //collectionsExamples.priorityQueueDemo();
        //collectionsExamples.arrayDequeDemo();
        //collectionsExamples.hashMapDemo();
        //collectionsExamples.treeMapDemo();
        //collectionsExamples.linkedHashMapDemo();
        //collectionsExamples.enumMapDemo();
        //collectionsExamples.enumDemo();
        //collectionsExamples.comparatorDemo();
        //collectionsExamples.arraysMethodsDemo();
        //collectionsExamples.propertiesDemo();

        GenDemo genDemo = new GenDemo();
        //genDemo.genericsDemo();

        IOExamples ioExamples = new IOExamples();
        //ioExamples.consoleReaderExample();
        //ioExamples.consoleReaderStringsExample();
        //ioExamples.fileReaderExample();
        //ioExamples.fileReaderTryWithResourcesExample();
        //ioExamples.fileWriterExample();
        //ioExamples.fileClassDemo();
        ioExamples.serializableExampleDemo();

    }


}