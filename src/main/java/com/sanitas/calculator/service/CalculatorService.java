package com.sanitas.calculator.service;

import java.math.BigDecimal;

public interface CalculatorService {

    double calculate(BigDecimal num1, BigDecimal num2, String operation);
}
