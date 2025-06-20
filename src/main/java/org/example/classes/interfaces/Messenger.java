package org.example.classes.interfaces;

public interface Messenger {

    int NO = 0;
    int YES = 1;
    int MAYBE = 2;
    int LATER = 3;
    int NEVER = 4;

    public void sendMessage(String message);

    public String getMessage();

    public default String getErrorMessage() {
        return "some error occurred";
    }
}
