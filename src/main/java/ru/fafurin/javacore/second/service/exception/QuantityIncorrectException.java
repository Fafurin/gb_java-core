package ru.fafurin.javacore.second.service.exception;

public class QuantityIncorrectException extends RuntimeException {
    private final String message = "An incorrect number of products has been entered";

    @Override
    public String getMessage() {
        return this.message;
    }

}
