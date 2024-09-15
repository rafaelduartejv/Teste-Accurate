package com.calculadora.Teste.Accurate.controller;

import com.calculadora.Teste.Accurate.model.Calculo;
import com.calculadora.Teste.Accurate.model.ResultadoCalculo;
import com.calculadora.Teste.Accurate.service.CalculadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculadoraControllerTest {

    @Mock
    private CalculadoraService calculadoraService;

    @InjectMocks
    private CalculadoraController calculadoraController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calcularComSucesso() {
        String expressao = "3 * 3";
        double resultadoEsperado = 9.0;
        ResultadoCalculo resultadoMock = new ResultadoCalculo(expressao, resultadoEsperado, LocalDateTime.now());
        when(calculadoraService.calcular(expressao)).thenReturn(resultadoMock);

        Calculo pedido = new Calculo(expressao);
        ResponseEntity<ResultadoCalculo> resposta = calculadoraController.calcular(pedido);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertNotNull(resposta.getBody());
        assertEquals(resultadoEsperado, resposta.getBody().getResultado());
        verify(calculadoraService, times(1)).calcular(expressao);
    }

        @Test
        void calcularComExpressaoInvalida() {
            String expressaoInvalida = "3 +/ 1";
            when(calculadoraService.calcular(expressaoInvalida)).thenThrow(new IllegalArgumentException("Expressão inválida"));

            Calculo pedido = new Calculo(expressaoInvalida);
            ResponseEntity<ResultadoCalculo> resposta = calculadoraController.calcular(pedido);

            assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
            verify(calculadoraService, times(1)).calcular(expressaoInvalida);
        }

    @Test
    void calcularComExpressaoNulaOuVazia() {
        Calculo pedidoVazio = new Calculo(null);
        ResponseEntity<ResultadoCalculo> resposta = calculadoraController.calcular(pedidoVazio);

        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        verify(calculadoraService, never()).calcular(anyString());
    }
}
