package net.gelatto.labs.java_sdk;

public class ApiException extends Exception {
    private int statusCode;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

