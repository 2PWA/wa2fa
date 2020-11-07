package com.ppwa.wa2fa.otp.infrastructure;

public class CodeNotValidException extends RuntimeException {

    private static final String MESSAGE = "Not valid code";

    public CodeNotValidException() {
        super(MESSAGE);
    }

    public CodeNotValidException(String message) {
        super(message);
    }
}
