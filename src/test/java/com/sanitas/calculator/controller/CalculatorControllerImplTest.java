package com.sanitas.calculator.controller;

import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.utils.exceptions.OperationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorControllerImpl.class)
class CalculatorControllerImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CalculatorService calculatorService;

    @Value("${calculator.presentation.path.base}")
    private String basePath;

    @Value("${calculator.presentation.path.operation}")
    private String operationPath;

    @Test
    void operationAddValid() throws Exception {
        // Given
        BigDecimal num1 = new BigDecimal("5.0");
        BigDecimal num2 = new BigDecimal("3.0");
        String operation = "add";
        BigDecimal result = num1.add(num2);
        double expected = result.doubleValue();

        when(calculatorService
                .calculate(any(BigDecimal.class), any(BigDecimal.class), anyString()))
                .thenReturn(expected);

        // When
        mvc.perform(get(basePath + operationPath)
                        .param("num1", String.valueOf(num1))
                        .param("num2", String.valueOf(num2))
                        .param("operation", operation))
                // Then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(expected));
    }

    @Test
    void operationSubstractValid() throws Exception {
        // Given
        BigDecimal num1 = new BigDecimal("5.0");
        BigDecimal num2 = new BigDecimal("3.0");
        String operation = "substract";
        BigDecimal result = num1.subtract(num2);
        double expected = result.doubleValue();

        when(calculatorService
                .calculate(any(BigDecimal.class), any(BigDecimal.class), anyString()))
                .thenReturn(expected);

        // When
        mvc.perform(get(basePath + operationPath)
                        .param("num1", String.valueOf(num1))
                        .param("num2", String.valueOf(num2))
                        .param("operation", operation))
                // Then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(expected));
    }

    @Test
    void operationNotFound() throws Exception {
        // Given
        BigDecimal num1 = new BigDecimal("5.0");
        BigDecimal num2 = new BigDecimal("3.0");
        String operation = "+";

        when(calculatorService
                .calculate(any(BigDecimal.class), any(BigDecimal.class), anyString()))
                .thenThrow(OperationException.class);

        // When
        mvc.perform(get(basePath + operationPath)
                        .param("num1", String.valueOf(num1))
                        .param("num2", String.valueOf(num2))
                        .param("operation", operation))
                // Then
                .andExpect(status().isBadRequest());
    }
}