package com.io2.exception;

/**
 * Created by Niki on 2017-04-07.
 */
public class EmailExistsException extends Throwable {
    public EmailExistsException(String message) {
        super(message);
    }
}
