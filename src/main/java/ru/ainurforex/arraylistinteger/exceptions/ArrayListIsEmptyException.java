package ru.ainurforex.arraylistinteger.exceptions;

public class ArrayListIsEmptyException extends RuntimeException{
    public ArrayListIsEmptyException() {
    }

    public ArrayListIsEmptyException(String message) {
        super(message);
    }
}
