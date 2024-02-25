package com.ealgaworks.algafoodapi.api.domain.service;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Cidade;
import com.ealgaworks.algafoodapi.api.domain.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> listarTodasCidades() {
        return cidadeRepository.listar();
    }


    public Cidade buscarPorId(Long cidadeId) {
        Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);

        if (cidadeAtual == null) {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }

        return cidadeAtual;
    }

}
