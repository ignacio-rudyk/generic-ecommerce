package com.ignacio.rudyk.generic.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends EcommerceException {

    private static final int CODE = 3;

    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    private static final String BAD_REQUEST_EXCEPTION = "El/Los datos vienen en null o mal formados";

    public BadRequestException(String message) {
        super(message, CODE, HTTP_STATUS);
    }

    public BadRequestException() {
        this(BAD_REQUEST_EXCEPTION);
    }

}