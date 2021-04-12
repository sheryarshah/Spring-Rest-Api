package org.noyo.exceptions;

import org.springframework.http.HttpStatus;

/**
 * When raised, this will cause a 409 CONFLICT with the provided message.
 */
public final class HttpException extends Exception {
    public HttpException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
