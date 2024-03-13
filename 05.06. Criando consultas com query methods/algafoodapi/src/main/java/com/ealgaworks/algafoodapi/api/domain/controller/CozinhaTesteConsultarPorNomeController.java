package com.ealgaworks.algafoodapi.api.domain.controller;

import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.api.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class CozinhaTesteConsultarPorNomeController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> consultarPorNome(@RequestParam("nome") String nome) {
        // List<Cozinha> cozinha = cozinhaRepository.nome(nome);

        List<Cozinha> cozinha = cozinhaRepository.findTodasByNome(nome);
        return cozinha;
    }

    @GetMapping("/cozinhas/unica-por-nome")
    public Optional<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome) {
        // List<Cozinha> cozinha = cozinhaRepository.nome(nome);

        Optional<Cozinha> cozinha = cozinhaRepository.findByNome(nome);
        return cozinha;
    }
}
