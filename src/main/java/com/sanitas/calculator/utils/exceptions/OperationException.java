package com.sanitas.calculator.utils.exceptions;

import lombok.Getter;

@Getter
public class OperationException extends Exception {

    public OperationException(String message) {
        super(message);
    }
}
