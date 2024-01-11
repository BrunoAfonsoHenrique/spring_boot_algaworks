package com.rojetoclientes.clienteapi.principais;

import com.rojetoclientes.clienteapi.ClienteapiApplication;
import com.rojetoclientes.clienteapi.jpa.CadastroClienteJPA;
import com.rojetoclientes.clienteapi.model.Cliente;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InlcusaoClienteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ClienteapiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroClienteJPA cadastroCliente = applicationContext
                .getBean(CadastroClienteJPA.class);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Bruno Afonso");
        cliente1.setEmail("bruno@yahoo.com.br");
        cliente1.setTelefone("11988887777");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Henrique Pereira");
        cliente2.setEmail("henrique314@gmail.com");
        cliente2.setTelefone("21933332222");

        cliente1 =  cadastroCliente.salvarCliente(cliente1);
        cliente2 =  cadastroCliente.salvarCliente(cliente2);

        System.out.printf("%d - %s\n",cliente1.getId(), cliente1.getNome());
        System.out.printf("%d - %s\n",cliente2.getId(), cliente2.getNome());

    }
}
