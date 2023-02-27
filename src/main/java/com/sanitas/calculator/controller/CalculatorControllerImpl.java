package com.sanitas.calculator.controller;

import com.sanitas.calculator.service.CalculatorService;
import io.corp.calculator.TracerAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CalculatorControllerImpl implements CalculatorController {

    private final CalculatorService calculatorService;

    private final TracerAPI tracerAPI;

    @Override
    public ResponseEntity<Double> calcular(BigDecimal num1, BigDecimal num2, String operation) {
        double result = calculatorService.calculate(num1, num2, operation);
        tracerAPI.trace(result);
        return ResponseEntity.ok().body(result);
    }
}
