package org.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(new LockThread("firstThread", lock)).start();
        new Thread(new LockThread("secondThread", lock)).start();
    }
}
