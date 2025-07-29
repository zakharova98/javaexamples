package org.example.multithreading;

public class CallMe {

    public CallMe() {
    }

    public void call(String message) {
    //public synchronized void call(String message) {
        System.out.print(Thread.currentThread().getName() + " [" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error during calling: " + e.getMessage());
        }
        System.out.println("]");
    }
}
