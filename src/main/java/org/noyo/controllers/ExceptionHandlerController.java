package org.noyo.controllers;


import org.noyo.dto.ErrorResponse;
import org.noyo.exceptions.HttpException;
import org.noyo.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    /**
     * Raises an error with the provided message and status code.
     *
     * @param e The exception with the message embedded.
     * @return An error message with the status code.
     */
    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<ErrorResponse> handleHttpException(HttpException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), e.getHttpStatus());
    }

    /**
     * Raises an error when person is not found by id
     *
     * @param ex The exception with the message embedded.
     * @return An error message to response body
     */
    @ResponseBody
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personNotFoundHandler(PersonNotFoundException ex) {
        return ex.getMessage();
    }
}
