package com.ealgaworks.algafoodapi.api.domain.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepositoryQueries {

    List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}