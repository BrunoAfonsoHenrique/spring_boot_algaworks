package com.ealgaworks.algafoodapi.api.principais.formapagamento;

import com.ealgaworks.algafoodapi.AlgafoodapiApplication;
import com.ealgaworks.algafoodapi.api.domain.model.FormaDePagamento;
import com.ealgaworks.algafoodapi.api.domain.repository.FormaPagamentoReository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ListarTodasFormasDePagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoReository pagamentoRepository = applicationContext
                .getBean(FormaPagamentoReository.class);

        List<FormaDePagamento> listaFormasDeagamentos = pagamentoRepository.listar();

        for (FormaDePagamento listaFormasDeagamento : listaFormasDeagamentos) {
            System.out.println(listaFormasDeagamento.getDescricao());
        }
    }

}
