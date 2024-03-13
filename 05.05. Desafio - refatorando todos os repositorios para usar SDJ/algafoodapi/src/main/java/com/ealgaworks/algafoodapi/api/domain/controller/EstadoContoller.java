package com.ealgaworks.algafoodapi.api.domain.controller;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeEmUsoException;
import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Estado;
import com.ealgaworks.algafoodapi.api.domain.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoContoller {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoService.listarTodosEstados();
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
        try {
            Estado estadoBuscado = estadoService.buscarPorId(estadoId);
            return ResponseEntity.status(HttpStatus.FOUND).body(estadoBuscado);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Estado> adicionar(@RequestBody Estado estado) {
        estado = estadoService.adicionarNovoEstado(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estado);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long id,
                                            @RequestBody Estado estado) {
        try {
            estadoService.atualizarEstado(id, estado);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Estado> deletar(@PathVariable Long id) {
        try {
            estadoService.deletarEstado(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
