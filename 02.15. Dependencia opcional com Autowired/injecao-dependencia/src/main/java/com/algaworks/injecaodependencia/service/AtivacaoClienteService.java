package com.algaworks.injecaodependencia.service;

import com.algaworks.injecaodependencia.model.Cliente;
import com.algaworks.injecaodependencia.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired(required = false)
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        if (notificador != null) {
            this.notificador.notificar(cliente, "Seu cadastro esta ativo");
        }
        System.out.println("Não existe notificador, mas cliente foi ativado");

    }

    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }
}
