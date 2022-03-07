package com.demo.comparecars.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {

    private HttpStatus httpStatus;
    private String error;

    public GenericException(String error, HttpStatus httpStatus) {
        super(error);
        this.error=error;
        this.httpStatus=httpStatus;
    }

}
