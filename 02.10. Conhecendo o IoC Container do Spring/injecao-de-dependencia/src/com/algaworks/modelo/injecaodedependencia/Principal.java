package com.algaworks.modelo.injecaodedependencia;

import com.algaworks.modelo.injecaodedependencia.model.Cliente;
import com.algaworks.modelo.injecaodedependencia.model.Produto;
import com.algaworks.modelo.injecaodedependencia.service.ComprarProdutoService;
import com.algaworks.modelo.injecaodedependencia.service.Notificador;
import com.algaworks.modelo.injecaodedependencia.service.NotificarClienteSMS;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {

        Cliente joao = new Cliente("Joao", "11988885555", "11122233355", "joao@gmail.com");
        Produto produto = new Produto("Iphone", "Smatphone tecnologico", BigDecimal.valueOf(9380));

        Notificador notificador = new NotificarClienteSMS();

        ComprarProdutoService comprarProduto =  new ComprarProdutoService(notificador);
        comprarProduto.comprarProduto(joao, produto);

    }
}