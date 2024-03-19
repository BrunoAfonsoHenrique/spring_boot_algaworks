package com.estudo.consultadecep.controller;

import com.estudo.consultadecep.model.dto.CepDTO;
import com.estudo.consultadecep.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class BuscaEnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepDTO> buscar(@PathVariable String cep) {
        CepDTO endereco = enderecoService.buscarEnderecoPorCep(cep);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }
}
