package com.algaworks.sistemanotificacao.service;

import com.algaworks.sistemanotificacao.model.Cliente;
import com.algaworks.sistemanotificacao.model.Produto;

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
