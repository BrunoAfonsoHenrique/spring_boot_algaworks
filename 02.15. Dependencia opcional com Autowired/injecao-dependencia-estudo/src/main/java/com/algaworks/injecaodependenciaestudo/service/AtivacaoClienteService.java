package com.algaworks.injecaodependenciaestudo.service;

import com.algaworks.injecaodependenciaestudo.model.Cliente;
import com.algaworks.injecaodependenciaestudo.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private Notificador notificador;

//    @Autowired // é obrigatório se a classe tive rmais de um construtor
//    public AtivacaoClienteService(Notificador notificador) {
//        this.notificador = notificador;
//    }

//    public AtivacaoClienteService(String qualquer) {
//    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro esta ativo");
    }

    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }
}
