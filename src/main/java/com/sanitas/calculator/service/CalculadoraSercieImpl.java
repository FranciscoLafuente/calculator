package com.sanitas.calculator.service;

import com.sanitas.calculator.utils.Operacion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class CalculadoraSercieImpl implements CalculadoraService {

    @Override
    public double calcular(BigDecimal num1, BigDecimal num2, String operacion) {
        log.info(">> Calculando el resultado de: {} {} {}", num1, operacion, num2);

        Operacion op = Operacion.getSignoOperacion(operacion);

        switch (op) {
            case SUMAR -> {
                return num1.add(num2).doubleValue();
            }
            case RESTAR -> {
                return num1.subtract(num2).doubleValue();
            }
            default -> {
                log.info("Operacion no soportada");
                throw new RuntimeException("Operación no soportada para ser calculada: " + op);
            }
        }
    }
}
