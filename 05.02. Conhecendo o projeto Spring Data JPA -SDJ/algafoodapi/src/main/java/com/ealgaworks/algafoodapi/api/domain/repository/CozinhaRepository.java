package com.ealgaworks.algafoodapi.api.domain.repository;



import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();

    List<Cozinha> consultarPorNome(String nome);

    Cozinha buscar(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Long id);
}
