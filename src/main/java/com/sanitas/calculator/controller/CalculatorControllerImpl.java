package com.sanitas.calculator.controller;

import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.utils.exceptions.OperationException;
import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CalculatorControllerImpl implements CalculatorController {

    private final CalculatorService calculatorService;

    private final TracerImpl tracer = new TracerImpl();

    @Override
    public ResponseEntity<Double> calculate(BigDecimal num1, BigDecimal num2, String operation) throws OperationException {
        double result = calculatorService.calculate(num1, num2, operation);
        tracer.trace(result);
        return ResponseEntity.ok().body(result);
    }
}
