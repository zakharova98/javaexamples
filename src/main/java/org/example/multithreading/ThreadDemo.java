package org.example.multithreading;

public class ThreadDemo {

    /*public static void main(String[] args) {
        NewThread newThread = new NewThread();  // создать новый поток
        newThread.getT().start();               // запустить новый поток (с метода run)

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        System.out.println("Main Thread finishing");
    }*/

    public static void main(String[] args) {
        SecondThread newThread = new SecondThread();    // создать новый поток
        newThread.start();                              // запустить новый поток

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        System.out.println("Main Thread finishing");
    }


}
