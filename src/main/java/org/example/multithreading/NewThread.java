package org.example.multithreading;

public class NewThread implements Runnable {

    private String name;
    private Thread t;

    public NewThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Daughter's thread: " + t);
    }

    public NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted: " + e.getMessage());
        }
        System.out.println(name + " finishing");
    }

    public Thread getT() {
        return t;
    }

    public String getName() {
        return name;
    }
}
