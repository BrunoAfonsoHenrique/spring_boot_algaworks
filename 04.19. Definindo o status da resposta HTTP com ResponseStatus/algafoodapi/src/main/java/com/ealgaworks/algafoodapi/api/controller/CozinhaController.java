package com.ealgaworks.algafoodapi.api.controller;

import com.ealgaworks.algafoodapi.api.model.CozinhaXmlWraper;
import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.repository.CozinhaRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar1() {
        System.out.println("Listar 1");
        return cozinhaRepository.listar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{cozinhaId}")
    public Cozinha buscar(@PathVariable Long cozinhaId) {
       return cozinhaRepository.buscarPorId(cozinhaId);
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXmlWraper listarXml() {
        return new CozinhaXmlWraper(cozinhaRepository.listar());
    }


}
