package org.example.classes.interfaces;

public class WhatsApp implements Messenger{

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message + " to whatsapp");
    }

    @Override
    public String getMessage() {
        return "Get message from whatsapp";
    }
}
