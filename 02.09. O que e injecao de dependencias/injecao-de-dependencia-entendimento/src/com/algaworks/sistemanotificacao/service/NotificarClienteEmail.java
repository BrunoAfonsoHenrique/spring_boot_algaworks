package com.algaworks.sistemanotificacao.service;

import com.algaworks.sistemanotificacao.model.Cliente;

public class NotificarClienteEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente) {
        System.out.printf("Notificando %s através do email: %s\n",
                cliente.getNome(), cliente.getEmail());
    }
}
