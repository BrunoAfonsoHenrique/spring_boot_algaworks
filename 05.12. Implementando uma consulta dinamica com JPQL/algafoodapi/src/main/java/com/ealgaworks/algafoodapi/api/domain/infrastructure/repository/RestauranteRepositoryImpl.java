package com.ealgaworks.algafoodapi.api.domain.infrastructure.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RestauranteRepositoryImpl {

    @PersistenceContext
    private EntityManager manager;

    public List<Restaurante> find(String nome,
                                  BigDecimal taxaFreteInicial,
                                  BigDecimal taxaFreteFinal) {

        HashMap<String, Object> parametros = new HashMap<String, Object>();

        var jpql = new StringBuilder();
        jpql.append("from Restaurante where 0 = 0 ");

        if (StringUtils.hasLength(nome)) {
            jpql.append("and nome like :nome ");
            parametros.put("nome", "%" + nome + "%");
        }

        if (taxaFreteInicial != null) {
            jpql.append("and taxaFrete >= :taxaInicial ");
            parametros.put("taxaInicial", taxaFreteInicial);
        }

        if (taxaFreteFinal != null) {
            jpql.append("and taxaFrete <= :taxaFinal ");
            parametros.put("taxaFinal", taxaFreteFinal);
        }


        TypedQuery<Restaurante> query =
                manager.createQuery(jpql.toString(), Restaurante.class);

        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

        return query.getResultList();
    }


}
