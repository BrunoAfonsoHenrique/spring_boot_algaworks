package com.algaworks.algafoodapi.notication;

import com.algaworks.algafoodapi.model.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NotificadorSMS implements Notificacao {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do SMS, usando o telefone: %s: %s\n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
