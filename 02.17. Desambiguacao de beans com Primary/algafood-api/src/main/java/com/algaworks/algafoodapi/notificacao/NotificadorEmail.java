package com.algaworks.algafoodapi.notificacao;


import com.algaworks.algafoodapi.model.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s: %s\n",
                cliente.getNome(), cliente.getEmail(),  mensagem);
    }
}
