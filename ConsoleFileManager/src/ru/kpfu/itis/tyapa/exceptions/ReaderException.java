package ru.kpfu.itis.tyapa.exceptions;

/**
 * Thrown when some problems with reading user's commands occur;
 */

public class ReaderException extends RuntimeException {

    public ReaderException() {
        super();
    }
    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, Throwable exception) {
        super(message, exception);
    }

    public ReaderException(Throwable exception) {
        super(exception);
    }
}
