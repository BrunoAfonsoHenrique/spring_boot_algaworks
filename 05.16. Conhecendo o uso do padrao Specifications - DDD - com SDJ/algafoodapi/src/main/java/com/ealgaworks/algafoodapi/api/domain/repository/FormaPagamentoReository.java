package com.ealgaworks.algafoodapi.api.domain.repository;

import com.ealgaworks.algafoodapi.api.domain.model.FormaDePagamento;

import java.util.List;

public interface FormaPagamentoReository {

    List<FormaDePagamento> listar();

    FormaDePagamento buscarPorId(Long id);

    FormaDePagamento salvar(FormaDePagamento formapagamento);

    void remover(FormaDePagamento formapagamento);
}
