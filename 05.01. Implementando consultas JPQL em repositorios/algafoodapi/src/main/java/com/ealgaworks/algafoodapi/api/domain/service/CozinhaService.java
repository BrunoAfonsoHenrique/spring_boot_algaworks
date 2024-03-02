package com.ealgaworks.algafoodapi.api.domain.service;

import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeEmUsoException;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Estado;
import com.ealgaworks.algafoodapi.api.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {


    private CozinhaRepository cozinhaRepository;

    public CozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public List<Cozinha> listarTodasCozinhas() {
        return cozinhaRepository.listar();
    }

    public Cozinha buscarPorId(Long id) {
        Cozinha cozinha = cozinhaRepository.buscar(id);

        if(cozinha == null)  {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }

        return cozinha;
    }

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);
    }

    public void atualizarCozinha(Long cozinhaId, Cozinha cozinha) {
        Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);

        if (cozinhaAtual == null) {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }
        BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
        cozinhaRepository.salvar(cozinhaAtual);

    }

    public void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.remover(cozinhaId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Entidade não localizada na Base de dados");
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Não pode remover - Entidade associada a outra tabela");
        }

    }



}
