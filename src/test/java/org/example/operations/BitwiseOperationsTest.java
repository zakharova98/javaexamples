package org.example.operations;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BitwiseOperationsTest {

    public BitwiseOperations bitwiseOperations = new BitwiseOperations();

    @Test
    public void testBitwiseComplement() {
        int a = 42;         // 00101010
        int expected = -43; // 11010101
        int actual = bitwiseOperations.bitwiseComplement(a);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBitwiseAnd() {
        int a = 42;         // 00101010
        int b = 15;         // 00001111
        int expected = 10;  // 00001010

        int actual = bitwiseOperations.bitwiseAnd(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBitwiseOr() {
        int a = 42;         // 00101010
        int b = 15;         // 00001111
        int expected = 47;  // 00101111

        int actual = bitwiseOperations.bitwiseOr(a, b);
        Assertions.assertEquals(expected, actual);

    }

    // результирующий бит = 1, если соответствующий бит только в одном из операндов равен 1
    // во всех других случаях результирующий бит равен 0
    @Test
    public void testBitwiseXor() {
        int a = 42;         // 00101010
        int b = 15;         // 00001111
        int expected = 37;  // 00100101

        int actual = bitwiseOperations.bitwiseXor(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBitwiseShiftLeft() {
        int a = 3;          // 0011
        int expected = 6;   // 0110

        int actual = bitwiseOperations.bitwiseShiftLeft(a, 1);
        Assertions.assertEquals(expected, actual);

        expected = 12; // 1100
        actual = bitwiseOperations.bitwiseShiftLeft(a, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBitwiseShiftRight() {
        int a = 12;         // 1100
        int expected = 6;   // 0110

        int actual = bitwiseOperations.bitwiseShiftRight(a, 1);
        Assertions.assertEquals(expected, actual);

        expected = 3; // 0011
        actual = bitwiseOperations.bitwiseShiftRight(a, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBitwiseShiftRightWithNull() {
        int a = 78;         // 1001110
        int expected = 39;  // 0100111

        int actual = bitwiseOperations.bitwiseShiftRightWithNull(a, 1);
        Assertions.assertEquals(expected, actual);
    }
}