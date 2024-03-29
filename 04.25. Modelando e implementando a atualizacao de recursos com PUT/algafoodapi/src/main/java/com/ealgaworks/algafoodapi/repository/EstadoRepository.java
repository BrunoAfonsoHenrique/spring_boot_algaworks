package com.ealgaworks.algafoodapi.repository;

import com.ealgaworks.algafoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado buscarPorId(Long id);

    Estado salvar(Estado estado);

    void remover(Estado estado);
}
