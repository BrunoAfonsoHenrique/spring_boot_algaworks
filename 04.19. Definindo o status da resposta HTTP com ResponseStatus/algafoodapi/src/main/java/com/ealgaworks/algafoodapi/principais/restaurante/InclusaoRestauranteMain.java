package com.ealgaworks.algafoodapi.principais.restaurante;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext
                .getBean(RestauranteRepository.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        cozinha.setNome("Tailandesa");

        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Pokemon");
        restaurante.setTaxaFrete(BigDecimal.valueOf(5.89));
        restaurante.setCozinha(cozinha);

        restauranteRepository.salvar(restaurante);


    }

}
