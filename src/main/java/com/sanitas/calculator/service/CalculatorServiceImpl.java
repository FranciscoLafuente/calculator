package com.sanitas.calculator.service;

import com.sanitas.calculator.utils.domain.Operation;
import com.sanitas.calculator.utils.exceptions.OperationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double calculate(BigDecimal num1, BigDecimal num2, String operation) throws OperationException {
        log.info(">> Calculando el resultado de: {} {} {}", num1, operation, num2);

        Operation op = Operation.getSignoOperacion(operation);
        double result = 0;

        switch (op) {
            case ADD -> {
                result = num1.add(num2).doubleValue();
            }
            case SUBSTRACT -> {
                result = num1.subtract(num2).doubleValue();
            }
        }
        return result;
    }
}
