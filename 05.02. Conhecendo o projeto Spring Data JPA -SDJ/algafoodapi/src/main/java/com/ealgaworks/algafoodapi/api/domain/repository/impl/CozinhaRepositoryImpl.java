package com.ealgaworks.algafoodapi.api.domain.repository.impl;

import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.api.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    public Cozinha buscar(Long id) {
        Cozinha cozinhaBuscada = manager.find(Cozinha.class, id);
        return cozinhaBuscada;
    }

    @Override
    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = manager.
                createQuery("from Cozinha", Cozinha.class);

        return query.getResultList();
    }

//    @Override
//    public List<Cozinha> consultarPorNome(String nome) {
//        return manager.createQuery("from Cozinha where nome= :nome", Cozinha.class)
//                .setParameter("nome", nome)
//                .getResultList();
//    }

    @Override
    public List<Cozinha> consultarPorNome(String nome) {
        return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Cozinha cozinha = buscar(id);
        if (cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }
}
