package com.ealgaworks.algafoodapi.api.domain.service;

import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeEmUsoException;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.repository.CozinhaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
@Service
public class CadastroCozinhaService {


    private CozinhaRepository cozinhaRepository;

    public CadastroCozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);
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
