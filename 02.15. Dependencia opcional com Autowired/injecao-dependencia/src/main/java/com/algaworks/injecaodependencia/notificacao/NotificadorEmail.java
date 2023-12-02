package com.algaworks.injecaodependencia.notificacao;

import com.algaworks.injecaodependencia.model.Cliente;
import org.springframework.stereotype.Component;

//@Component
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s: %s\n",
                cliente.getNome(), cliente.getEmail(),  mensagem);
    }
}
