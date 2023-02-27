package com.sanitas.calculator.utils.domain;

import com.sanitas.calculator.utils.exceptions.OperationException;
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

    public static Operation getSignoOperacion(String valor) throws OperationException {
        return Arrays.stream(OPERATIONS)
                .filter(operation -> valor.equalsIgnoreCase(operation.name()) ||
                        valor.equalsIgnoreCase(operation.getOp()))
                .findFirst()
                .orElseThrow(() -> new OperationException("Operacion no soportada"));
    }
}
