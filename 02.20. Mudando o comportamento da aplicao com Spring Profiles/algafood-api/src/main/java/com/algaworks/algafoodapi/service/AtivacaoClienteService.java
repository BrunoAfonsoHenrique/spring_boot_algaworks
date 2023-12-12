package com.algaworks.algafoodapi.service;

import com.algaworks.algafoodapi.model.Cliente;
import com.algaworks.algafoodapi.notificacao.NivelUrgencia;
import com.algaworks.algafoodapi.notificacao.Notificador;
import com.algaworks.algafoodapi.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
    }
}
