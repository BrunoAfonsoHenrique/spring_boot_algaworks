package com.ealgaworks.algafoodapi.principais;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.jpa.CadastroCozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaCozinhaIdMain {

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
