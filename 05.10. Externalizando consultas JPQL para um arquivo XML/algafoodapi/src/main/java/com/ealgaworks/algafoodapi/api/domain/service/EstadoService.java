package com.ealgaworks.algafoodapi.api.domain.service;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeEmUsoException;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Estado;
import com.ealgaworks.algafoodapi.api.domain.repository.EstadoRepository;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class EstadoService {

    private EstadoRepository estadoRepository;


    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> listarTodosEstados() {
        return estadoRepository.findAll();
    }

    public Estado buscarPorId(Long estadoId) {
        Optional<Estado> estadoAtual = estadoRepository.findById(estadoId);

        if (estadoAtual.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Entidade nao licalizada na base de dados.");
        }

        return estadoAtual.get();

    }

    public Estado adicionarNovoEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void atualizarEstado(Long id, Estado estado) {

        Optional<Estado> estadoAtual = estadoRepository.findById(id);

        if (estadoAtual.isPresent()) {
            BeanUtils.copyProperties(estado, estadoAtual.get(), "id");
            estadoRepository.save(estadoAtual.get());

        } else {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }

    }


    public void deletarEstado(Long estadoId) {
        try {
            estadoRepository.deleteById(estadoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Entidade não localizada na Base de dados");

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Não pode remover - Entidade associada a outra tabela");
        }

    }
}
