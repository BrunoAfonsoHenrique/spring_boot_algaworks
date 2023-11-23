package com.algaworks.modelo.injecaodependencia;

import com.algaworks.modelo.injecaodependencia.model.Cliente;
import com.algaworks.modelo.injecaodependencia.notificacao.NotificadoEmail;
import com.algaworks.modelo.injecaodependencia.service.AtivacaoClienteService;
import com.algaworks.modelo.injecaodependencia.service.Notificador;

public class Principal {

    public static void main(String[] args) {

        Cliente bruno = new Cliente("Bruno", "bgarcia@gmail.com", "44444444");
        Cliente alex = new Cliente("Alexander", "alex@outlook.com", "55555555");

        Notificador notificador = new NotificadoEmail();

        AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(notificador);
        ativacaoCliente.ativar(bruno);
        ativacaoCliente.ativar(alex);


    }
}
