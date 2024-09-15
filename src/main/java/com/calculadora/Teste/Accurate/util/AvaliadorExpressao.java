package com.calculadora.Teste.Accurate.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AvaliadorExpressao {

    public static double avaliar(String expressao) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        if (engine == null) {
            throw new IllegalStateException("Motor JavaScript não encontrado");
        }

        Object resultado = engine.eval(expressao);

        if (resultado instanceof Number) {
            double valor = ((Number) resultado).doubleValue();
            if (Double.isInfinite(valor)) {
                throw new ArithmeticException("Divisão por zero detectada");
            }
            return valor;
        } else {
            throw new ScriptException("Tipo de resultado inválido: " + resultado.getClass().getName());
        }
    }
}

