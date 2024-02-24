package com.ealgaworks.algafoodapi.api.principais.formapagamento;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.api.domain.model.FormaDePagamento;
import com.ealgaworks.algafoodapi.api.domain.repository.FormaPagamentoReository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoPagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoReository formaPagamentoRepository = applicationContext
                .getBean(FormaPagamentoReository.class);

        FormaDePagamento formaDePagamento = new FormaDePagamento();
        formaDePagamento.setDescricao("Pix");

        formaPagamentoRepository.salvar(formaDePagamento);

    }
}
