package com.ealgaworks.algafoodapi.api.domain.repository.impl;

import com.ealgaworks.algafoodapi.api.domain.model.FormaDePagamento;
import com.ealgaworks.algafoodapi.api.domain.repository.FormaPagamentoReository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoReository {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public FormaDePagamento salvar(FormaDePagamento formapagamento) {
        return manager.merge(formapagamento);
    }

    @Override
    public FormaDePagamento buscarPorId(Long id) {

        FormaDePagamento formaDePagamento = manager.find(FormaDePagamento.class, id);
        return formaDePagamento;
    }

    @Override
    public List<FormaDePagamento> listar() {
        return manager.createQuery("from FormaDePagamento", FormaDePagamento.class).getResultList();

    }

    @Transactional
    @Override
    public void remover(FormaDePagamento formapagamento) {
        manager.remove(formapagamento);

    }
}
