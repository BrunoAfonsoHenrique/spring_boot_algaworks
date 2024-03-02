package com.ealgaworks.algafoodapi.api.principais.restaurante;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.api.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import javax.persistence.TransactionRequiredException;

public class ExclusaoRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository formaPagamentoRepository = applicationContext
                .getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setId(1L);
        try {
            formaPagamentoRepository.remover(restaurante1);
        } catch (TransactionRequiredException e) {
            System.out.println("Não é possível excluir o restaurante, esta associadfo a outra tabela.");
        }

    }
}
