package com.calculadora.Teste.Accurate.repository;

import com.calculadora.Teste.Accurate.model.ResultadoCalculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculadoraRepository extends JpaRepository<ResultadoCalculo, Long> {
}
