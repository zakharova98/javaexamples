package org.example.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorExample {

    public void iteratorDemo() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String day = iterator.next();
            System.out.println("element = " + day);
        }

        System.out.println();
        ListIterator<String> listIterator = list.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            i++;
            String day = listIterator.next();
            listIterator.set(i + " " + day);
        }
        System.out.println("\nModified list:");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            String day = iterator.next();
            System.out.println(day);
        }
        System.out.println();
    }
}
