package com.sanitas.calculator.service;

import java.math.BigDecimal;

public interface CalculadoraService {

    double calcular(BigDecimal num1, BigDecimal num2, String operacion);
}
