package org.example.classes.interfaces;

public class Viber implements Messenger{

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message + " to viber");
    }

    @Override
    public String getMessage() {
        return "Get message from viber";
    }
}
