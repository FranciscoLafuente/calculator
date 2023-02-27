package com.sanitas.calculator.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Operation {
    ADD("+"),
    SUBSTRACT("-");

    private static final Operation[] OPERATIONS = new Operation[]{ADD, SUBSTRACT};

    private final String op;

    public static Operation getSignoOperacion(String valor) {
        return Arrays.stream(OPERATIONS)
                .filter(operation -> valor.equalsIgnoreCase(operation.name()) ||
                        valor.equalsIgnoreCase(operation.getOp()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Operacion no soportada"));
    }
}
