package com.sanitas.calculator.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Operacion {
    SUMAR("+"),
    RESTAR("-");

    private static final Operacion[] operaciones = new Operacion[]{SUMAR, RESTAR};

    private final String op;

    public static Operacion getSignoOperacion(String valor) {
        return Arrays.stream(operaciones)
                .filter(operacion -> valor.equalsIgnoreCase(operacion.name()) ||
                        valor.equalsIgnoreCase(operacion.getOp()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Operacion no soportada"));
    }
}
