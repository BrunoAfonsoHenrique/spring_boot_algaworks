package br.com.algaworks.algafood.notificacao;

import br.com.algaworks.algafood.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadoEmail  {

    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
