package com.ealgaworks.algafoodapi.api.domain.controller;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Cidade;
import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.api.domain.service.CidadeService;
import com.ealgaworks.algafoodapi.api.domain.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;


    @GetMapping
    public List<Cidade> listar() {

        return cidadeService.listarTodasCidades();
    }


    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
        try {
            Cidade cidadeBuscada = cidadeService.buscarPorId(cidadeId);
            return ResponseEntity.status(HttpStatus.FOUND).body(cidadeBuscada);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    @PostMapping("/incluir-nova-cidade")
    public ResponseEntity<Cidade> adicionar() {

        return null;
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cidade> atualizar() {

        return null;
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Cidade> deletar() {

        return null;
    }
}
