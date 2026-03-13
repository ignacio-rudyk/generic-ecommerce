package com.ignacio.rudyk.generic.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends EcommerceException {

    private static final int CODE = 2;

    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

    private static final String USER_NOT_FOUND_EXCEPTION = "El usuario no existe";

    public UserNotFoundException(String message) {
        super(message, CODE, HTTP_STATUS);
    }

    public UserNotFoundException() {
        this(USER_NOT_FOUND_EXCEPTION);
    }

}
