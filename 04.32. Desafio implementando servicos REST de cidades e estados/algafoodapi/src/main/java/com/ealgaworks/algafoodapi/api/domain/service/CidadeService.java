package com.ealgaworks.algafoodapi.api.domain.service;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeEmUsoException;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Cidade;
import com.ealgaworks.algafoodapi.api.domain.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.salvar(cidade);
    }

    public void atualizarCidade(Long cozinhaId, Cidade cidade) {

        Cidade cidadeAtual = cidadeRepository.buscar(cozinhaId);

        if (cidadeAtual == null) {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }

        BeanUtils.copyProperties(cidade, cidadeAtual, "id");
        cidadeRepository.salvar(cidadeAtual);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.remover(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Entidade não localizada na Base de dados");
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Não pode remover - Entidade associada a outra tabela");
        }
    }

}
