package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.model.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
