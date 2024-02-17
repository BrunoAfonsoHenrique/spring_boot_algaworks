package com.ealgaworks.algafoodapi.repository;



import com.ealgaworks.algafoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();

    Cozinha buscarPorId(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Long id);
}
