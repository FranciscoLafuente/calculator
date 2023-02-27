package com.sanitas.calculator.service;

import com.sanitas.calculator.utils.exceptions.OperationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
class CalculatorServiceTest {

    @SpyBean
    private CalculatorService calculatorService;

    @Test
    void operationAddValid() throws OperationException {
        // Given
        BigDecimal num1 = new BigDecimal("5.0");
        BigDecimal num2 = new BigDecimal("3.0");
        String operation = "add";
        BigDecimal result = num1.add(num2);
        double expected = result.doubleValue();

        double actual = calculatorService.calculate(num1, num2, operation);

        assertEquals(expected, actual);
    }

    @Test
    void operationSubstractValid() throws OperationException {
        // Given
        BigDecimal num1 = new BigDecimal("5.0");
        BigDecimal num2 = new BigDecimal("3.0");
        String operation = "substract";
        BigDecimal result = num1.subtract(num2);
        double expected = result.doubleValue();

        double actual = calculatorService.calculate(num1, num2, operation);

        assertEquals(expected, actual);
    }

    @Test
    void operationNotSupported() throws OperationException {
        // Given
        BigDecimal num1 = new BigDecimal("5.0");
        BigDecimal num2 = new BigDecimal("3.0");
        String operation = "other";

        doThrow(OperationException.class)
                .when(calculatorService)
                .calculate(any(BigDecimal.class), any(BigDecimal.class), anyString());

        assertThrows(OperationException.class, () -> calculatorService.calculate(num1, num2, operation));
    }
}