package org.example.exceptions;

public class MyException extends Exception {
    private int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    public MyException() {
    }

    @Override
    public String toString() {
        return "MyException [" +
                "detail=" + detail +
                ']';
    }
}
