package com.algaworks.injecaodependenciaestudo.notificacao;


import com.algaworks.injecaodependenciaestudo.model.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
