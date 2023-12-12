package br.com.algaworks.algafood.service;

import br.com.algaworks.algafood.model.Cliente;
import br.com.algaworks.algafood.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private Notificador notificador;

//    @Autowired
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
