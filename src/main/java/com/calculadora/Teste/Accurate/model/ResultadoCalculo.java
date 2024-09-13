package com.calculadora.Teste.Accurate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ResultadoCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expressao;
    private double resultado;
    private LocalDateTime timestamp;

    public ResultadoCalculo(String expressao, double resultado, LocalDateTime timestamp) {
        this.expressao = expressao;
        this.resultado = resultado;
        this.timestamp = timestamp;
    }
}
