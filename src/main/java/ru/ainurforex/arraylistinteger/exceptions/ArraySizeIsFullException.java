package ru.ainurforex.arraylistinteger.exceptions;

public class ArraySizeIsFullException extends RuntimeException {
    public ArraySizeIsFullException() {
    }

    public ArraySizeIsFullException(String message) {
        super(message);
    }
}
