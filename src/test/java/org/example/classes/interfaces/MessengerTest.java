package org.example.classes.interfaces;


import org.junit.Assert;
import org.junit.Test;

public class MessengerTest {

    @Test
    public void testMessenger() {

        Messenger messenger = new Telegram();

        String message = messenger.getMessage();
        Assert.assertEquals("Get message from telegram", message);

        Assert.assertTrue(messenger instanceof Telegram);
        Assert.assertTrue(messenger instanceof Messenger);

        Assert.assertFalse(messenger instanceof Viber);
        Assert.assertFalse(messenger instanceof WhatsApp);

        Assert.assertEquals(1, messenger.YES);

        Assert.assertEquals("some error occurred", messenger.getErrorMessage());

        Messenger videoMessenger = new SomeVideoMessenger();
        Assert.assertEquals("some error with video occurred", videoMessenger.getErrorMessage());
    }

}