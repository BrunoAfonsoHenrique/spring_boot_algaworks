package com.algaworks.modelo.injecaodependencia.service;

import com.algaworks.modelo.injecaodependencia.model.Cliente;

public class AtivacaoClienteService {

    Notificador notificador;

    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro esta ativo");
    }
}
