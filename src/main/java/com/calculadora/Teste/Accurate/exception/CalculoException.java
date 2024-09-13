package com.calculadora.Teste.Accurate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CalculoException extends RuntimeException {
    public CalculoException(String mensagem) {
        super(mensagem);
    }
    public CalculoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
