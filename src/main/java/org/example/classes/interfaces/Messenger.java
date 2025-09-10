package org.example.classes.interfaces;

public interface Messenger {

    public void sendMessage(String message);

    public String getMessage();

    public default String getErrorMessage() {
        return "some error occurred";
    }
}
