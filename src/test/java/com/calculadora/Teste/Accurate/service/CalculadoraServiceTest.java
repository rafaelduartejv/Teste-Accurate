package com.calculadora.Teste.Accurate.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.calculadora.Teste.Accurate.model.ResultadoCalculo;
import com.calculadora.Teste.Accurate.repository.CalculadoraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

class CalculadoraServiceTest {

    @Mock
    private CalculadoraRepository calculadoraRepository;

    @InjectMocks
    private CalculadoraService calculadoraService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calcularExpressaoValida() throws Exception {
        String expressao = "2 + 2";
        double resultadoEsperado = 4.0;

        ResultadoCalculo resultadoCalculoMock = new ResultadoCalculo(expressao, resultadoEsperado, LocalDateTime.now());
        when(calculadoraRepository.save(any(ResultadoCalculo.class))).thenReturn(resultadoCalculoMock);

        ResultadoCalculo resultado = calculadoraService.calcular(expressao);

        assertNotNull(resultado);
        assertEquals(resultadoEsperado, resultado.getResultado());
        assertEquals(expressao, resultado.getExpressao());
        verify(calculadoraRepository, times(1)).save(any(ResultadoCalculo.class));
    }

    @Test
    void calcularComExpressaoInvalida() {
        String expressaoInvalida = " / 1";
        when(calculadoraService.calcular(expressaoInvalida)).thenThrow(new IllegalArgumentException("Expressão inválida"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.calcular(expressaoInvalida);
        });
        assertEquals("Expressão inválida", exception.getMessage());
        verify(calculadoraService, times(1)).calcular(expressaoInvalida);
    }
}
