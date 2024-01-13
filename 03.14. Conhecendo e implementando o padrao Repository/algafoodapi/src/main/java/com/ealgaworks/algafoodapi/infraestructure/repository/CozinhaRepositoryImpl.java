package com.ealgaworks.algafoodapi.infraestructure.repository;

import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.repository.CozinhaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }
    @Override
    public Cozinha buscarPorId(Long id) {
        Cozinha cozinhaBuscada = manager.find(Cozinha.class, id);
        return cozinhaBuscada;
    }

    @Override
    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = manager.
                createQuery("from Cozinha", Cozinha.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public void remover(Cozinha cozinha) {
        cozinha = buscarPorId(cozinha.getId());
        manager.remove(cozinha);
    }
}
