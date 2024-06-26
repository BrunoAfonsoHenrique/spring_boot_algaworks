package com.ealgaworks.algafoodapi.api.domain.infrastructure.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl {

    @PersistenceContext
    private EntityManager manager;

    public List<Restaurante> find(String nome,
                                  BigDecimal taxaFreteInicial,
                                  BigDecimal taxaFreteFinal) {

        var jpql = "from Restaurante where nome like :nome " +
                "and  taxaFrete between : taxaInicial and :taxaFinal";

        return manager.createQuery(jpql, Restaurante.class)
                .setParameter("nome", "%" + nome + "%")
                .setParameter("taxaInicial", taxaFreteInicial)
                .setParameter("taxaFinal", taxaFreteFinal)
                .getResultList();
    }


}
