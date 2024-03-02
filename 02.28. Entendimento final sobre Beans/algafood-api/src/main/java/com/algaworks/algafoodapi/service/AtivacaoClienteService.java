package com.algaworks.algafoodapi.service;

import com.algaworks.algafoodapi.model.Cliente;
import com.algaworks.algafoodapi.notication.Notificacao;
import com.algaworks.algafoodapi.notication.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private Notificacao notificador;

    public void ativarCliente(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Cliente ativado");

    }


}
