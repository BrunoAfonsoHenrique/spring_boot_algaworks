package com.estudo.consultadecep.service;

import com.estudo.consultadecep.model.dto.CepDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

    @Autowired
    private RestTemplate restTemplate;

    public CepDTO buscarEnderecoPorCep(String cep) {
        CepDTO EnderecoBuscado = restTemplate.getForEntity("https://viacep.com.br/ws/"+ cep +"/json/", CepDTO.class).getBody();
        return EnderecoBuscado;
    }
}
