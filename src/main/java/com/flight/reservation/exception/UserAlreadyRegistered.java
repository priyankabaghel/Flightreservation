package com.flight.reservation.exception;

public class UserAlreadyRegistered extends RuntimeException{
    public UserAlreadyRegistered(String message) {
        super(message);
    }
}
