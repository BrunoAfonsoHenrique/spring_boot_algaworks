package com.algaworks.modelo.injecaodedependencia.service;

import com.algaworks.modelo.injecaodedependencia.model.Cliente;
import com.algaworks.modelo.injecaodedependencia.model.Produto;

public class ComprarProdutoService {

    Notificador notificador;

    public ComprarProdutoService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void comprarProduto(Cliente cliente, Produto produto) {
        this.notificador.notificar(cliente);
        System.out.printf("O Cliente: %s, com CPF: %s comprou o produto: %s pelo preco de: R$%.2f\n",
                cliente.getNome(), cliente.getCpf(), produto.getNome(), produto.getPreco());
    }
}
