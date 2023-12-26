package com.algaworks.algafoodapi.notication;

import com.algaworks.algafoodapi.model.Cliente;

public interface Notificacao {

    public void notificar(Cliente cliente, String mensagem);
}
