package br.com.algaworks.algafood.service;

import br.com.algaworks.algafood.model.Cliente;
import br.com.algaworks.algafood.notificacao.Notificador;
import org.springframework.stereotype.Component;

public class AtivacaoClienteService {

    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;

        System.out.println("AtivacaoClienteService: " + notificador);
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro esta ativo");
    }
}
