package com.ealgaworks.algafoodapi.api.domain.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();

    Permissao buscarPorId(Long id);

    Permissao salvar(Permissao permissao);

    void remover(Permissao permissao);
}
