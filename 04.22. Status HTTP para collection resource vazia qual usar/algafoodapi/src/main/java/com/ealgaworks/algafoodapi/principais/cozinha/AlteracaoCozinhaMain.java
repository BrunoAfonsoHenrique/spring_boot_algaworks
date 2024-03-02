package com.ealgaworks.algafoodapi.principais.cozinha;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cadastroCozinha = applicationContext
                .getBean(CozinhaRepository.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setId(1L);
        cozinha1.setNome("Brasileira");

        cadastroCozinha.salvar(cozinha1);


    }

}
