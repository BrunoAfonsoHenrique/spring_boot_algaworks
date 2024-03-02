package com.algaworks.modelo.injecaodedependencia.service;

import com.algaworks.modelo.injecaodedependencia.model.Cliente;

public class NotificarClienteEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente) {
        System.out.printf("Notificando %s através do email: %s\n",
                cliente.getNome(), cliente.getEmail());
    }
}
