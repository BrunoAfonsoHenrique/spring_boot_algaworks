package com.algaworks.sistemanotificacao.service;

import com.algaworks.sistemanotificacao.model.Cliente;

public class NotificarClienteSMS implements Notificador{

    @Override
    public void notificar(Cliente cliente) {
        System.out.printf("Notificando por SMS o cliente: %s através do telefone: %s\n",
                cliente.getNome(), cliente.getTelefone());
    }
}
