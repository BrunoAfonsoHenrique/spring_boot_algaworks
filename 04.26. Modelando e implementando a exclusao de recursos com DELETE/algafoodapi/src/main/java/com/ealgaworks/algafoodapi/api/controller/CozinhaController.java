package com.ealgaworks.algafoodapi.api.controller;

import com.ealgaworks.algafoodapi.api.model.CozinhaXmlWraper;
import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }


    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
        Cozinha cozinha = cozinhaRepository.buscarPorId(cozinhaId);
        if (cozinha != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXmlWraper listarXml() {
        return new CozinhaXmlWraper(cozinhaRepository.listar());
    }

    @PostMapping("/incluir-nova-cozinha")
    public ResponseEntity<Cozinha> adicionarNovaCozinha(@RequestBody Cozinha cozinha) {
        Cozinha cozinhaSalva = cozinhaRepository.salvar(cozinha);
        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaSalva);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cozinha> atualizarCozinha(@PathVariable Long id,
                                                    @RequestBody Cozinha cozinha) {
        Cozinha cozinhaAtual = cozinhaRepository.buscarPorId(id);
        //cozinhaAtual.setNome(cozinha.getNome());
        if (cozinhaAtual != null) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaAtual);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Cozinha> deletarCozinha(@PathVariable Long id) {
        try {
            Cozinha cozinhaBuscada = cozinhaRepository.buscarPorId(id);
            if (cozinhaBuscada != null) {
                cozinhaRepository.remover(cozinhaBuscada);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }


    }


}
