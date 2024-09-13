package com.calculadora.Teste.Accurate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Calculo {

    private String expressao;

    public Calculo(String expressao) {
        this.expressao = expressao;
    }
}
