package com.ealgaworks.algafoodapi.api.controller;

import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.repository.CozinhaRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar1() {
        System.out.println("Listar 1");
        return cozinhaRepository.listar();
    }

//    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
//    public List<Cozinha> listar2() {
//        System.out.println("Listar 2");
//        return cozinhaRepository.listar();
//    }

    @GetMapping("/{cozinhaId}")
    public Cozinha buscar(@PathVariable Long cozinhaId) {
       return cozinhaRepository.buscarPorId(cozinhaId);
    }


}
