package br.com.algaworks.algafood.config;

import br.com.algaworks.algafood.notificacao.Notificador;
import br.com.algaworks.algafood.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
        return new AtivacaoClienteService(notificador);
    }
}
