package com.algaworks.algafoodapi.notication;

import com.algaworks.algafoodapi.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificacao {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
