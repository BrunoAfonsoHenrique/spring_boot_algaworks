package com.ealgaworks.algafoodapi.api.principais.formapagamento;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.api.domain.model.FormaDePagamento;
import com.ealgaworks.algafoodapi.api.domain.repository.FormaPagamentoReository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoFormaDePagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoReository formaDePagamento = applicationContext
                .getBean(FormaPagamentoReository.class);

        FormaDePagamento formaDePagamentoUm = new FormaDePagamento();
        formaDePagamentoUm.setId(1L);
        formaDePagamentoUm.setDescricao("Pix");

        formaDePagamento.salvar(formaDePagamentoUm);


    }

}
