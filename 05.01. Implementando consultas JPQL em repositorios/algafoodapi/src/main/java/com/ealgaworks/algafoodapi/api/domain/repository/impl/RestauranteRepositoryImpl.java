package com.ealgaworks.algafoodapi.api.domain.repository.impl;

import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.api.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public Restaurante buscarPorId(Long id) {
        Restaurante restauranteBuscado = manager.find(Restaurante.class, id);
        return restauranteBuscado;
    }

    @Override
    public List<Restaurante> listar() {
        TypedQuery<Restaurante> query = manager.
                createQuery("from Restaurante", Restaurante.class);

        return query.getResultList();
    }

    @Override
    public void remover(Restaurante restaurante) {
        restaurante = buscarPorId(restaurante.getId());
        manager.remove(restaurante);
    }

}
