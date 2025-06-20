package org.example.classes.interfaces;

public class Telegram implements Messenger{

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message + " to telegram");
    }

    @Override
    public String getMessage() {
        return "Get message from telegram";
    }
}
