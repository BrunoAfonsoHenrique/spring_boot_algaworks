package com.ealgaworks.algafoodapi.api.domain.service;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeEmUsoException;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Cidade;
import com.ealgaworks.algafoodapi.api.domain.model.Estado;
import com.ealgaworks.algafoodapi.api.domain.repository.CidadeRepository;
import com.ealgaworks.algafoodapi.api.domain.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> listarTodasCidades() {
        return cidadeRepository.findAll();
    }


    public Cidade buscarPorId(Long cidadeId) {
        Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);

        if (cidadeAtual.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }

        return cidadeAtual.get();
    }

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();

        Estado estadoBuscado = estadoRepository.findById(estadoId).orElseThrow(() ->
                new EntidadeNaoEncontradaException(
                        String.format("Nao existe estado cadastrado com o id informado %d" , estadoId)));

        cidade.setEstado(estadoBuscado);
        return cidadeRepository.save(cidade);
    }

    public void atualizarCidade(Long cozinhaId, Cidade cidade) {

        Optional<Cidade> cidadeAtual = cidadeRepository.findById(cozinhaId);

        if (cidadeAtual.isPresent()) {
            BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
            cidadeRepository.save(cidadeAtual.get());
        } else {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Entidade não localizada na Base de dados");
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Não pode remover - Entidade associada a outra tabela");
        }
    }

}
