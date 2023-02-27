package com.sanitas.calculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@RequestMapping("${calculadora.presentation.path.base}")
public interface CalculatorController {

    @Operation(summary = "Obtiene el resultado de la operacion indicada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Resultado de la operacion",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "Operacion invalida",
                    content = @Content)})
    @GetMapping("${calculadora.presentation.path.calcular}")
    ResponseEntity<Double> calcular(
            @NotNull @Parameter(description = "Primer numero de la operacion", required = true)
            @RequestParam(name = "num1") BigDecimal num1,
            @NotNull @Parameter(description = "Segundo numero de la operacion", required = true)
            @RequestParam(name = "num2") BigDecimal num2,
            @NotEmpty @Parameter(description = "Operacion a realizar", required = true)
            @RequestParam(name = "operacion") String operacion);
}
