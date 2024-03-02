package com.ealgaworks.algafoodapi.repository;

import com.ealgaworks.algafoodapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();

    Restaurante buscarPorId(Long id);

    Restaurante salvar(Restaurante restaurante);

    void remover(Restaurante restaurante);
}
