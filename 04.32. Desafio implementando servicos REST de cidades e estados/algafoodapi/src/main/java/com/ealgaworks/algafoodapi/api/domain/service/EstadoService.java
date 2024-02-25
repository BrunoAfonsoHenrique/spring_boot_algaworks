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

@Service
@Data
public class EstadoService {

    private EstadoRepository estadoRepository;


    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> listarTodosEstados() {
        return estadoRepository.listar();
    }

    public Estado buscarPorId(Long estadoId) {
        Estado estadoAtual = estadoRepository.buscar(estadoId);

        if (estadoAtual == null) {
            throw new EntidadeNaoEncontradaException("Entidade nao licalizada na base de dados.");
        }

        return estadoAtual;

    }

    public Estado adicionarNovoEstado(Estado estado) {
        return estadoRepository.salvar(estado);
    }

    public void atualizarEstado(Long id, Estado estado) {

        Estado estadoAtual = estadoRepository.buscar(id);

        if (estadoAtual == null) {
            throw new EntidadeNaoEncontradaException("Entidade nao encontrada na base de dados");
        }
        BeanUtils.copyProperties(estado, estadoAtual, "id");
        estadoRepository.salvar(estadoAtual);
    }

    public void deletarEstado(Long estadoId) {
        try {
            estadoRepository.remover(estadoId);
        } catch (EmptyResultDataAccessException e) {
        throw new EntidadeNaoEncontradaException("Entidade não localizada na Base de dados");
    } catch (DataIntegrityViolationException e) {
        throw new EntidadeEmUsoException("Não pode remover - Entidade associada a outra tabela");
    }

    }
}
