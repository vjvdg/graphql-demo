package com.vjvdg.graphqldemo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GenericException extends RuntimeException {

    private final String code;
    private final String message;

    public GenericException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
