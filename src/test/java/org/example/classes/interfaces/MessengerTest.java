package org.example.classes.interfaces;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MessengerTest {

    @Test
    public void testMessenger() {

        Messenger messenger = new Telegram();

        String message = messenger.getMessage();
        Assertions.assertEquals("Get message from telegram", message);

        Assertions.assertTrue(messenger instanceof Telegram);
        Assertions.assertTrue(messenger instanceof Messenger);

        Assertions.assertFalse(messenger instanceof Viber);
        Assertions.assertFalse(messenger instanceof WhatsApp);

        Assertions.assertEquals(1, messenger.YES);

        Assertions.assertEquals("some error occurred", messenger.getErrorMessage());

        Messenger videoMessenger = new SomeVideoMessenger();
        Assertions.assertEquals("some error with video occurred", videoMessenger.getErrorMessage());
    }

}