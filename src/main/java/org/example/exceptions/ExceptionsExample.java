package org.example.exceptions;

import java.io.*;

public class ExceptionsExample {

    public ExceptionsExample() {
    }

    public void notCaughtException() {
        int d = 0;

        int k = 5;

        int a = k / d; // java.lang.ArithmeticException: / by zero
    }

    public void caughtException() {
        int d = 0;
        int k = 5;

        try {
            int a = k / d; // java.lang.ArithmeticException: / by zero
            System.out.println("it is not output");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");

            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("After catch");
    }

    public void nestedCaughtException(int d) {
        try {
            System.out.print(" 0 ");
            try {
                System.out.print(" 1 ");
                int k = 68756/d;
                System.out.print(" 2 ");
            } catch (ArithmeticException e) {
                System.out.print(" 3 ");
                throw e;
            } finally {
                System.out.print(" 4 ");
            }
            System.out.print(" 5 ");
        } catch (RuntimeException e) {
            System.out.print(" 6 ");
            throw e;
        } finally {
            System.out.print(" 7 ");
        }
        System.out.print(" 8 ");
    }

    public void throwExceptionExample(int value) throws Exception{
        int mod = value % 2;
        if (mod == 0) {
            System.out.println(value + " is even value");
        } else {
            String message = value + " is odd value";
            System.out.println(message);

            throw new Exception("message");
        }
    }


    //public void checkedExceptionExample() throws FileNotFoundException {
    public void checkedExceptionExample() {

       // исключение FileNotFoundException, если somefile.json не существует

       //FileReader fileReader = new FileReader("somefile.json");
        try {
            FileReader fileReader = new FileReader("somefile.json");
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        } finally {
            System.out.println("finally");
        }
    }

    public void uncheckedExceptionExample(int value) {
        int[] numbers = new int[10];

        numbers[value] = value;
    }

    public void myExceptionExample(int a) throws MyException {
        System.out.println("\nMy Exception example");

        if (a > 100) {
            throw new MyException(a);
        } else {
            System.out.println("Standard value: " + a);
        }
    }

    public void causedExceptionExample() throws MyException{
        MyException myException = new MyException(200);
        myException.initCause(new IllegalArgumentException("Cause"));

        throw myException;
    }

    public void tryWithResourceExample() {
        try (InputStream in = new FileInputStream("file.txt")) {
            // считывание данных из файла
        } catch (IOException exception) {
            // обработка ошибок ввода/вывода
            // здесь in будет автоматически закрыт
            System.out.println("Exception: " + exception.getMessage());
        }

        String string = "This is test string";
        Reader reader = new StringReader(string);
        BufferedReader bufferedReader = new BufferedReader(reader);
        try (bufferedReader) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
