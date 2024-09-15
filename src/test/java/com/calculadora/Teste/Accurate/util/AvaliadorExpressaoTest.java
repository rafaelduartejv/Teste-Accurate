package com.calculadora.Teste.Accurate.util;

import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

import static org.junit.jupiter.api.Assertions.*;

class AvaliadorExpressaoTest {

    @Test
    void avaliarExpressaoValida() throws ScriptException {
        String expressao = "10 + 20";
        double resultadoEsperado = 30.0;
        double resultado = AvaliadorExpressao.avaliar(expressao);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void avaliarExpressaoInvalida() {
        String expressao = "10 + / 2";  // Expressão inválida em JavaScript
        assertThrows(ScriptException.class, () -> AvaliadorExpressao.avaliar(expressao));
    }


    @Test
    void avaliarExpressaoComTipoInvalido() {
        String expressao = "texto";
        assertThrows(ScriptException.class, () -> AvaliadorExpressao.avaliar(expressao));
    }

    @Test
    void avaliarDivisaoPorZero() {
        String expressao = "10 / 0";  // Divisão por zero
        assertThrows(ArithmeticException.class, () -> AvaliadorExpressao.avaliar(expressao));
    }

}
