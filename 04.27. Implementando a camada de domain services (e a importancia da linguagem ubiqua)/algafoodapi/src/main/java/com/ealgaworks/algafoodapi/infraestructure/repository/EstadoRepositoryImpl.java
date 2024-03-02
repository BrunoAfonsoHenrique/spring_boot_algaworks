package com.ealgaworks.algafoodapi.infraestructure.repository;

import com.ealgaworks.algafoodapi.domain.model.Estado;
import com.ealgaworks.algafoodapi.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }
    @Override
    public Estado buscarPorId(Long id) {
        Estado estadoBuscado = manager.find(Estado.class, id);
        return estadoBuscado;
    }

    @Override
    public List<Estado> listar() {
        TypedQuery<Estado> query = manager.
                createQuery("from Estado", Estado.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public void remover(Estado estado) {
        estado = buscarPorId(estado.getId());
        manager.remove(estado);
    }
}
