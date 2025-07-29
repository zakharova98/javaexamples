package org.example.multithreading;

public class Caller implements Runnable {

    private String message;
    private CallMe target;
    private Thread thread;

    public Caller(String message, CallMe target) {
        this.message = message;
        this.target = target;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(message);
        }
    }

    public String getMessage() {
        return message;
    }

    public CallMe getTarget() {
        return target;
    }

    public Thread getThread() {
        return thread;
    }
}
