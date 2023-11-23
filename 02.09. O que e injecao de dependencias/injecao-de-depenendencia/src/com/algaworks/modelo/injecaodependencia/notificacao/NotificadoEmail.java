package com.algaworks.modelo.injecaodependencia.notificacao;

import com.algaworks.modelo.injecaodependencia.model.Cliente;
import com.algaworks.modelo.injecaodependencia.service.Notificador;

public class NotificadoEmail implements Notificador {
    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
