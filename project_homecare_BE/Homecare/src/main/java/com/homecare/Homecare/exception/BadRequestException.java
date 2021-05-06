package com.homecare.Homecare.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String mess) {
        super(mess);
    }
}