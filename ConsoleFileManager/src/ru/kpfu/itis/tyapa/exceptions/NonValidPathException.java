package ru.kpfu.itis.tyapa.exceptions;

public class NonValidPathException extends RuntimeException {

    public NonValidPathException() {
        super();
    }
    public NonValidPathException(String message) {
        super(message);
    }

    public NonValidPathException(String message, Throwable exception) {
        super(message, exception);
    }

    public NonValidPathException(Throwable exception) {
        super(exception);
    }
}
