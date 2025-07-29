package org.example.multithreading;

public class MultiThreadDemo {

    public static void main(String[] args) {
        NewThread newThread1 = new NewThread("First");
        NewThread newThread2 = new NewThread("Second");
        NewThread newThread3 = new NewThread("Third");

        // запуск потоков
        newThread1.getT().start();
        newThread2.getT().start();
        newThread3.getT().start();

        System.out.println("First thread is running: " + newThread1.getT().isAlive());
        System.out.println("Second thread is running: " + newThread2.getT().isAlive());
        System.out.println("Third thread is running: " + newThread3.getT().isAlive());

        try {
            // ждем пока все потоки выполнятся
            //Thread.sleep(10000);

            System.out.println("Waiting for threads to finish");
            newThread1.getT().join();
            newThread2.getT().join();
            newThread3.getT().join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted: " + e.getMessage());
        }

        System.out.println("First thread is running: " + newThread1.getT().isAlive());
        System.out.println("Second thread is running: " + newThread2.getT().isAlive());
        System.out.println("Third thread is running: " + newThread3.getT().isAlive());

        System.out.println("Main Thread finishing");
    }
}
