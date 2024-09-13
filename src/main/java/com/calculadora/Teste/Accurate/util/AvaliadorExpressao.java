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
        try {
            Object resultado = engine.eval(expressao);
            if (resultado instanceof Number) {
                return ((Number) resultado).doubleValue();
            } else {
                throw new ScriptException("Tipo de resultado inválido: " + resultado.getClass().getName());
            }
        } catch (ScriptException e) {
            throw new ScriptException("Erro ao avaliar a expressão: " + e.getMessage());
        }
    }
}
