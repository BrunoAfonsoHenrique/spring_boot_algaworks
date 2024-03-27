package com.ealgaworks.algafoodapi.api.domain.infrastructure.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.api.domain.repository.RestauranteRepositoryQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

import java.util.ArrayList;
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

        ArrayList<Predicate> predicates = new ArrayList<Predicate>();

        //root é o Restaurante
        Root<Restaurante> root = criteria.from(Restaurante.class); // from Restaurante

        if (StringUtils.hasText(nome)) {
            predicates.add(criteriaBuilder.like(root.get("nome"), "%" + nome + "%"));
        }

        if (taxaFreteInicial != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        }

        if (taxaFreteFinal != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        }

        criteria.where(predicates.toArray(new Predicate[0])); // convertendo um List para um Array


        TypedQuery<Restaurante> query = manager.createQuery(criteria);
        return query.getResultList();

    }

    /*
        Um Predicate é uma condição ou expressão lógica que define critérios para filtrar resultados em uma consulta.
        Na API Criteria, um Predicate é usado para criar cláusulas de filtro (como WHERE) em consultas.
        Ele representa uma condição que deve ser verdadeira para que uma entidade seja incluída nos resultados da consulta.
     */


}
