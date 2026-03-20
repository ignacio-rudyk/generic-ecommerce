package com.ignacio.rudyk.generic.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends EcommerceException {

  private static final int CODE = 2;

  private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

  private static final String DATA_NOT_FOUND_EXCEPTION = "El/Los Dato/s proporcionados no existen";

  public DataNotFoundException(String message) {
    super(message, CODE, HTTP_STATUS);
  }

  public DataNotFoundException() {
    this(DATA_NOT_FOUND_EXCEPTION);
  }

}
