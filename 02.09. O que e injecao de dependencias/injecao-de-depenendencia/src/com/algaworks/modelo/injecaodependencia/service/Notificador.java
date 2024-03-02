package com.algaworks.modelo.injecaodependencia.service;

import com.algaworks.modelo.injecaodependencia.model.Cliente;

public interface Notificador {

    void notificar (Cliente cliente, String mensagem);
}
