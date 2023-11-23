package com.algaworks.modelo.injecaodependencia.service;

import com.algaworks.modelo.injecaodependencia.model.Cliente;
import com.algaworks.modelo.injecaodependencia.model.Produto;

public class EmissaoNotaFiscalService {

    Notificador notificador;

    public EmissaoNotaFiscalService(Notificador notificador) {
        this.notificador = notificador;
    }
    public void emitir(Cliente cliente, Produto produto) {
        // TODO emite nota fiscal aqui (Exemplo) ...

        this.notificador.notificar(cliente, "Nota fiscal do produto "
                + produto.getNome() + " foi emitida!");
    }
}
