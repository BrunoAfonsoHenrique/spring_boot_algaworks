package com.ealgaworks.algafoodapi.repository;

import com.ealgaworks.algafoodapi.domain.model.FormaDePagamento;

import java.util.List;

public interface FormaPagamentoReository {

    List<FormaDePagamento> listar();

    FormaDePagamento buscarPorId(Long id);

    FormaDePagamento salvar(FormaDePagamento formapagamento);

    void remover(FormaDePagamento formapagamento);
}
