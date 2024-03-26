package com.ealgaworks.algafoodapi.api.domain.infrastructure.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.api.domain.repository.RestauranteRepositoryQueries;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

import java.util.List;
@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    /*
    criteriaApi -> é uma api do JPA poderosa para criar queries de forma programatica (consultas complexas)
    permite montar uma querie usando código JAVA
    ideal -> consultas complexas e dinamicas
     */

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        //Interface -> CriteriaBuilder serve como uma fabrica para construir elementos que precisamos para construir uma consulta
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<Restaurante> criteria = criteriaBuilder.createQuery(Restaurante.class);
        //root é o Restaurante
        Root<Restaurante> root = criteria.from(Restaurante.class); // from Restaurante
        Predicate nomePredicate = criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
        Predicate taxaInicialPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial);
        Predicate taxaFinalPredicate = criteriaBuilder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal);

        criteria.where(nomePredicate, taxaInicialPredicate, taxaFinalPredicate);


        TypedQuery<Restaurante> query = manager.createQuery(criteria);
        return query.getResultList();

    }


}
