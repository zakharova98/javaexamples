package org.example.multithreading;

public class Synch {

    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller caller1 = new Caller("Hello", target);
        Caller caller2 = new Caller("Synchronized", target);
        Caller caller3 = new Caller("World", target);

        caller1.getThread().start();
        caller2.getThread().start();
        caller3.getThread().start();

        try {
            caller1.getThread().join();
            caller2.getThread().join();
            caller3.getThread().join();
        } catch (InterruptedException e) {
            System.out.println("Error during execution: " + e.getMessage());
        }
    }
}
