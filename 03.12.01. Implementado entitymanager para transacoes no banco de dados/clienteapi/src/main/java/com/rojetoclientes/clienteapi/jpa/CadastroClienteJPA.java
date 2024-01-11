package com.rojetoclientes.clienteapi.jpa;

import com.rojetoclientes.clienteapi.model.Cliente;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroClienteJPA {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        return manager.merge(cliente);
    }

    public Cliente buscarClientePorId(Long id) {
        return manager.find(Cliente.class, id);
    }

    public List<Cliente> listarTodosClientes() {
        TypedQuery<Cliente> query =
                manager.createQuery("from Clientes", Cliente.class);

        return query.getResultList();
    }

    @Transactional
    public void removerCliente(Cliente cliente) {
        cliente = buscarClientePorId(cliente.getId());
        manager.remove(cliente);
    }
}
