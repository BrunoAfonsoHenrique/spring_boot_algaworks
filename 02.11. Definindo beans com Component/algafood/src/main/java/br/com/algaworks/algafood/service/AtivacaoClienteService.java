package br.com.algaworks.algafood.service;

import br.com.algaworks.algafood.model.Cliente;
import br.com.algaworks.algafood.notificacao.NotificadoEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private NotificadoEmail notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro esta ativo");
    }
}
