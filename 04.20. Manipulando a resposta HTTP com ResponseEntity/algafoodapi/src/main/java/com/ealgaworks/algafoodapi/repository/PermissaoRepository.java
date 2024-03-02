package com.ealgaworks.algafoodapi.repository;

import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();

    Permissao buscarPorId(Long id);

    Permissao salvar(Permissao permissao);

    void remover(Permissao permissao);
}
