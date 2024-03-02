package com.ealgaworks.algafoodapi.api.domain.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.api.domain.model.Estado;
import com.ealgaworks.algafoodapi.api.domain.repository.EstadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        return manager.createQuery("from Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        Estado estadoBuscado = manager.find(Estado.class, id);
        return estadoBuscado;
    }



    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Estado estado = buscar(id);

        if (estado == null) {
            throw new EmptyResultDataAccessException(1);
        }

        manager.remove(estado);
    }

}
