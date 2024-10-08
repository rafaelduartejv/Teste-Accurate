package com.calculadora.Teste.Accurate.controller;

import com.calculadora.Teste.Accurate.model.Calculo;
import com.calculadora.Teste.Accurate.model.ResultadoCalculo;
import com.calculadora.Teste.Accurate.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping
    public ResponseEntity<ResultadoCalculo> calcular(@RequestBody Calculo pedido) {
        if (pedido.getExpressao() == null || pedido.getExpressao().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        ResultadoCalculo resultado = calculadoraService.calcular(pedido.getExpressao());
        return ResponseEntity.ok(resultado);
    }
}
