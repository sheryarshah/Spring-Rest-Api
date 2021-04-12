package org.noyo.exceptions;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id){
        super("Person not found " + id);
    }
}
