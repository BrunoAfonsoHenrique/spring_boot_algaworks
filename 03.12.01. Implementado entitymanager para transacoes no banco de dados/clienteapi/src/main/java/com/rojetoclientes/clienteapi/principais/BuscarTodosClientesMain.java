package com.rojetoclientes.clienteapi.principais;

import com.rojetoclientes.clienteapi.ClienteapiApplication;
import com.rojetoclientes.clienteapi.jpa.CadastroClienteJPA;
import com.rojetoclientes.clienteapi.model.Cliente;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BuscarTodosClientesMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ClienteapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroClienteJPA cadastroCliente = applicationContext
                .getBean(CadastroClienteJPA.class);

        List<Cliente> listaClientes = cadastroCliente.listarTodosClientes();


        for (Cliente listaCliente : listaClientes) {
            System.out.printf("%d - %s\n", listaCliente.getId(), listaCliente.getNome());
        }

    }
}
