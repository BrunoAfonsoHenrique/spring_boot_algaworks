package com.algaworks.injecaodependencia.notificacao;

import com.algaworks.injecaodependencia.model.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
