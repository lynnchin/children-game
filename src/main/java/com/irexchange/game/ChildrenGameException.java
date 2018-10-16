package com.irexchange.game;

public class ChildrenGameException extends RuntimeException {
    private final String message;

    public ChildrenGameException(String message) {
        this.message = message;
    }
}
