package org.example.classes.collections;

public class StringExamples {

    public void creationExample() {
        char[] chars = {'n', 'e', 'w', 'S', 't', 'r', 'i', 'n', 'g'};
        String str = new String(chars);
        System.out.println("str1 = " + str + " length = " + str.length());

        String str2 = new String(chars, 3, 6);
        System.out.println("\nstr2 = " + str2);

        String str3 = new String(str2);
        System.out.println("\nstr3 = " + str3);

        String str4 = "new String"; // использовать строковый литерал
        System.out.println("\nstr4 = " + str4);
    }

    public String concatenationExample(String str1, String str2) {
        return str1 + " " + str2;
    }

    public void equalsExample() {
        String str1 = "Hello World";
        String str2 = "hello world";

        System.out.println("str1 = " + str1 + " str2 = " + str2);
        System.out.println(" equals = " + str1.equals(str2));

        System.out.println("\nstr1 = " + str1 + " str2 = " + str2);
        System.out.println(" equals ignore case = " + str1.equalsIgnoreCase(str2));

        String str3 = new String(str1);
        System.out.println("\nstr1 = " + str1 + " str3 = " + str3);
        boolean result = (str1 == str3);
        System.out.println(" str1 == str3 = " + result);
    }

    public void compareToExample() {
        String str1 = "Hello";
        String str2 = "world";
        System.out.println("str1 = " + str1 + " str2 = " + str2);
        System.out.println("comareTo = " + str1.compareTo(str2));

        String str3 = "world";
        System.out.println("\nstr3 = " + str3 + " str2 = " + str2);
        System.out.println("comareTo = " + str3.compareTo(str2));

        String str4 = "World";
        System.out.println("\nstr4 = " + str4 + " str2 = " + str2);
        System.out.println("comareToIgoneCase = " + str4.compareToIgnoreCase(str2));
    }

    public void searchExample() {
        String str = "May the Force be with you";

        int indexF = str.indexOf(70);
        System.out.println("index of F (70 on ASCII) = " + indexF);

        int indexForce = str.indexOf("Force");
        System.out.println("index of Force = " + indexForce);

        int lastIndexW = str.indexOf(119);
        System.out.println("lastIndex of w (119 on ASCII) = " + lastIndexW);

        int indexWith = str.lastIndexOf("with", 2);
        System.out.println("last index of with from 2 position = " + indexWith);
    }


    public void modificationExample() {
        String str1 = "May the Force";
        String str2 = " be with you";

        String concat = str1.concat(str2);
        System.out.println("concatenation = " + concat);

        String subsrt = concat.substring(0, 3);
        System.out.println("Substring between o and 3 = " + subsrt);

        String replace = concat.replace("you", "us");
        System.out.println("replace = " + replace);

        String trim = str2.trim();
        System.out.println("str2 with trim = \"" + trim + "\"");
    }

    public void stringBuilderExample() {
        StringBuilder str1 = new StringBuilder("May the Force");
        StringBuilder str2 = new StringBuilder(" be with you");

        str1.append(str2);
        System.out.println("after append str1 = " + str1);

        str1.insert(25, "!");
        System.out.println("after insert str1 = " + str1);

        str1.reverse();
        System.out.println("after reverse = " + str1);

        str1.delete(0, 1);
        System.out.println("after delete str1 = " + str1);

        str1.reverse();
        str1.replace(22, 25, "us");
        System.out.println("after replace = " + str1);

        String substr = str1.substring(0, 3);
        System.out.println("substring between 0 and 3 = " + substr);
    }
}
