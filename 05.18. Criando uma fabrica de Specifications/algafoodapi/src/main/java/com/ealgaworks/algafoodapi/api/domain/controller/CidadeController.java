package com.ealgaworks.algafoodapi.api.domain.controller;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeEmUsoException;
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
    public ResponseEntity<Cidade> adicionar(@RequestBody Cidade cidade) {
        try {
            Cidade cidadeIncluida = cidadeService.salvar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(cidadeIncluida);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long id,
                                            @RequestBody Cidade cidade) {
        try {
            cidadeService.atualizarCidade(id, cidade);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Cidade> deletar(@PathVariable Long id) {
        try {
            cidadeService.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
