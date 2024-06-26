package com.ealgaworks.algafoodapi.api.domain.repository.impl;

import com.ealgaworks.algafoodapi.api.domain.model.Permissao;
import com.ealgaworks.algafoodapi.api.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Permissao salvar(Permissao permissao) {
        return manager.merge(permissao);
    }
    @Override
    public Permissao buscarPorId(Long id) {
        Permissao permissaoBuscada = manager.find(Permissao.class, id);
        return permissaoBuscada;
    }

    @Override
    public List<Permissao> listar() {
        TypedQuery<Permissao> query = manager.
                createQuery("from Permissao", Permissao.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {
        permissao = buscarPorId(permissao.getId());
        manager.remove(permissao);
    }
}
