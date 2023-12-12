package com.algaworks.algafoodapi.listener;

import com.algaworks.algafoodapi.notificacao.Notificador;
import com.algaworks.algafoodapi.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoService(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistea está ativo");
    }
}
