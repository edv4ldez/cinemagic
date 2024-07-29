package com.metaphorce.cinemagic.exceptions;

public class UserNotFoundException extends RuntimeException{
    public  UserNotFoundException(String message) {
        super(message);
    }
}
