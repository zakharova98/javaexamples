package org.example.multithreading;

interface MyNumber {
    double getNumber();
}

interface NumericTest {
    boolean test(int n);
}

interface NumericTestComparing {
    boolean test(int first, int second);
}

interface StringFunc<T> {
    T func(T t) throws Exception;
}

public class LambdaDemo {

    public void lambdaDemo() {
    //public static void main(String[] args) {
        MyNumber myNumber = () -> 3.14;
        System.out.println("MyNumber value is: " + myNumber.getNumber());

        myNumber = () -> Math.random() * 10;
        System.out.println("MyNumber random value is: " + myNumber.getNumber());
        System.out.println("MyNumber second random value is: " + myNumber.getNumber());
        System.out.println();

        NumericTest isEven = (n) -> (n % 2 == 0);
        System.out.println(isEven.test(10) ? "10 is even" : "10 is odd");
        System.out.println(isEven.test(9) ? "9 is even" : "9 is odd");
        System.out.println();

        NumericTest isNonNeg = (n) -> n >= 0;
        System.out.println(isNonNeg.test(10) ? "10 is a positive number" : "10 is negative number");
        System.out.println(isNonNeg.test(-5) ? "-5 is a positive number" : "-5 is negative number");
        System.out.println();

        NumericTestComparing comparing = (first, second) -> first > second;
        System.out.println(comparing.test(10, 100) ? "10 > 100" : "10 < 100");
        System.out.println(comparing.test(50, 5) ? "50 > 5" : "50 < 5");
    }

    //public void blockLambdaDemo() {
    public static void main(String[] args) throws Exception {
        StringFunc<String> reverseString = (str) -> {
            if (str.contains("!")) throw new Exception("Find forbidden character !");

            StringBuilder result = new StringBuilder();
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                result.append(str.charAt(i));
            }
            return result.toString();
        };

        String someString = "May the Force be with you!";
        System.out.println("Source String: " + someString);
        String reversedString = reverseString.func(someString);
        System.out.println("String after reverse: " + reversedString);
    }
}
