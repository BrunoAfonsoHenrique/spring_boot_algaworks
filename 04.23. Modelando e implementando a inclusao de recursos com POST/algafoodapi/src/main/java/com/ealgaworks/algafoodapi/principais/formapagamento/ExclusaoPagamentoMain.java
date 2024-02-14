package com.ealgaworks.algafoodapi.principais.formapagamento;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.domain.model.FormaDePagamento;
import com.ealgaworks.algafoodapi.repository.FormaPagamentoReository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoPagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoReository formaPagamentoRepository = applicationContext
                .getBean(FormaPagamentoReository.class);

        FormaDePagamento formaDePagamento = new FormaDePagamento();
        formaDePagamento.setDescricao("Pix");

        formaPagamentoRepository.remover(formaDePagamento);

    }
}
