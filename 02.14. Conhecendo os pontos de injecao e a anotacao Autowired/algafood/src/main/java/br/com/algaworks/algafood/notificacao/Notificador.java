package br.com.algaworks.algafood.notificacao;

import br.com.algaworks.algafood.model.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
