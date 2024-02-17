package com.ealgaworks.algafoodapi.api.principais.restaurante;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.api.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

public class AlteracaoRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository formaDePagamento = applicationContext
                .getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setId(1L);
        restaurante1.setNome("Restaurante Master chef");

        try {
            formaDePagamento.salvar(restaurante1);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Não é possivel alterar os dados do restaurante, pois está associado com outra tabela no BD.");
        }

    }

}
