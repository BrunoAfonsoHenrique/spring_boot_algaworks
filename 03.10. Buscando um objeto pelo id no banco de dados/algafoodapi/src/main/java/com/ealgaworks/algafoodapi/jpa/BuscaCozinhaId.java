package com.ealgaworks.algafoodapi.jpa;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BuscaCozinhaId {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext
                .getBean(CadastroCozinha.class);

        Cozinha cozinha = cadastroCozinha.buscarPorId(1L);

        System.out.println(cozinha.getNome());

    }

}
