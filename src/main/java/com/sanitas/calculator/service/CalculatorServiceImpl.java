package com.sanitas.calculator.service;

import com.sanitas.calculator.utils.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double calculate(BigDecimal num1, BigDecimal num2, String operation) {
        log.info(">> Calculando el resultado de: {} {} {}", num1, operation, num2);

        Operation op = Operation.getSignoOperacion(operation);

        switch (op) {
            case ADD -> {
                return num1.add(num2).doubleValue();
            }
            case SUBSTRACT -> {
                return num1.subtract(num2).doubleValue();
            }
            default -> {
                log.info("Operacion no soportada");
                throw new RuntimeException("Operación no soportada para ser calculada: " + op);
            }
        }
    }
}
