package com.calculadora.Teste.Accurate.service;

import com.calculadora.Teste.Accurate.exception.CalculoException;
import com.calculadora.Teste.Accurate.model.ResultadoCalculo;
import com.calculadora.Teste.Accurate.repository.CalculadoraRepository;
import com.calculadora.Teste.Accurate.util.AvaliadorExpressao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CalculadoraService {

    @Autowired
    private CalculadoraRepository calculadoraRepository;

    public ResultadoCalculo calcular(String expressao) {
        if (expressao == null || expressao.isEmpty()) {
            throw new IllegalArgumentException("A expressão não pode ser nula ou vazia");
        }
        double resultado;
        try {
            resultado = AvaliadorExpressao.avaliar(expressao);
        } catch (CalculoException e) {
            throw new IllegalArgumentException("Expressão inválida: " + expressao, e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro inesperado ao avaliar a expressão: " + expressao, e);
        }
        ResultadoCalculo resultadoCalculo = new ResultadoCalculo();
        resultadoCalculo.setResultado(resultado);
        resultadoCalculo.setExpressao(expressao);
        resultadoCalculo.setTimestamp(LocalDateTime.now());
        ResultadoCalculo resultadoSalvo = calculadoraRepository.save(resultadoCalculo);
        return resultadoSalvo;
    }
}
