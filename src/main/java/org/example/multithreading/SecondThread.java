package org.example.multithreading;

public class SecondThread extends Thread {

    public SecondThread() {
        super("Demo Thread");
        System.out.println("Daughter's thread: " + this);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Daughter's thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        System.out.println("Daughter's thread finishing");
    }
}
