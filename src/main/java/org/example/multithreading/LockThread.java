package org.example.multithreading;

import java.util.concurrent.locks.Lock;

public class LockThread implements Runnable {
    private String name;
    Lock lock;

    public LockThread(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Run of [" + name + "]");

        try {
            System.out.println("[" + name + "] wait locking of count");

            lock.lock();
            Shared.count++; // общий ресурс
            System.out.println("[" + name + "] " + Shared.count);

            System.out.println("[" + name + "] wating...");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("[" + name + "] Some error occurred: " + e.getMessage());
        } finally {
            System.out.println("[" + name + "] unlocking");
            lock.unlock();
        }
    }
}
