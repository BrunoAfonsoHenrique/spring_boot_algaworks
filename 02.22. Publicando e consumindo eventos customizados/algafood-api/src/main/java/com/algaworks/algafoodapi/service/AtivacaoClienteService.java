package com.algaworks.algafoodapi.service;

import com.algaworks.algafoodapi.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    public void ativar(Cliente cliente) {
        cliente.ativar();

        // dizer para o container que o cliente está ativo neste momento
        // emitir um evento
        // alguém na alicação vai ouvir esse evento/sinal
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));

    }

}
