package com.ealgaworks.algafoodapi.jpa;

import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    public Cozinha buscarPorId(Long id) {
        Cozinha cozinhaBuscada = manager.find(Cozinha.class, id);
        return cozinhaBuscada;
    }

    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = manager.
                createQuery("from Cozinha", Cozinha.class);

        return query.getResultList();
    }

    @Transactional
    public void remover(Cozinha cozinha) {
        cozinha = buscarPorId(cozinha.getId());
        manager.remove(cozinha);
    }




}
