package org.example.classes.interfaces;

public class SomeVideoMessenger implements VideoMessenger{

    @Override
    public void viewMessage() {
        // показывает видео
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message + " to some video messenger");
    }

    @Override
    public String getMessage() {
        return "Get message from some video messenger";
    }

    @Override
    public String getErrorMessage() {
        return "some error with video occurred";
    }
}
