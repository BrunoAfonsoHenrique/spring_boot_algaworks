package com.ealgaworks.algafoodapi.infraestructure.repository;

import com.ealgaworks.algafoodapi.domain.model.Permissao;
import com.ealgaworks.algafoodapi.repository.PermissaoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
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
