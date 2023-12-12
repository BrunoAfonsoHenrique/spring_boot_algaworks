package com.algaworks.modelo.injecaodependencia.notificacao;

import com.algaworks.modelo.injecaodependencia.model.Cliente;
import com.algaworks.modelo.injecaodependencia.service.Notificador;

public class NotificadoSms implements Notificador {
    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
