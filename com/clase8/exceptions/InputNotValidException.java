package com.clase8.exceptions;

public class InputNotValidException extends RuntimeException {
    public InputNotValidException(String message) {
        super(message);
    }
}
