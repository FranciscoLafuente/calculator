package com.sanitas.calculator.utils.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {

    private int status;
    private String code;
    private String exception;
    private String message;
    private String path = null;
    private String timestamp;

    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
