package org.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    Database databaseMock;

    @Test
    void queryTest() {
        Assertions.assertNotNull(databaseMock);
        Mockito.when(databaseMock.isAvailable()).thenReturn(true);

        Service t = new Service(databaseMock);
        boolean check = t.query("* from t");
        Assertions.assertTrue(check);

        Mockito.when(databaseMock.isExist(Mockito.anyString())).thenReturn(true);
        Assertions.assertTrue(t.isExist("Some request"));
        Assertions.assertTrue(t.isExist("Second request"));
        Assertions.assertTrue(t.isExist("Third request"));

        Mockito.doNothing().when(databaseMock.isExist(Mockito.anyString()));

    }
}