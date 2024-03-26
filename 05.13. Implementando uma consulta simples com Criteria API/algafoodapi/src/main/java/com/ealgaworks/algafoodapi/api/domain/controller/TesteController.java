package com.ealgaworks.algafoodapi.api.domain.controller;

import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.api.domain.repository.CozinhaRepository;
import com.ealgaworks.algafoodapi.api.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> consultarPorNome(@RequestParam("nome") String nome) {
        // List<Cozinha> cozinha = cozinhaRepository.nome(nome);

        // List<Cozinha> cozinha = cozinhaRepository.findTodasByNome(nome);

        List<Cozinha> cozinha = cozinhaRepository.findTodasByNomeContaining(nome);
        return cozinha;
    }

    @GetMapping("/cozinhas/unica-por-nome")
    public Optional<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome) {
        // List<Cozinha> cozinha = cozinhaRepository.nome(nome);

        Optional<Cozinha> cozinha = cozinhaRepository.findByNome(nome);
        return cozinha;
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> listarTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> listarTaxaFrete(String nome, Long cozinhaId) {
        return restauranteRepository.consultarPorNome(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> restaurantePrimeiroPorNome(String nome) {
        return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restauranteTop2PorNome(String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/por-nome-e-frete")
    public List<Restaurante> restaurantesPorNomeFrete(String nome,
                                                      BigDecimal taxaFreteInicial,
                                                      BigDecimal taxaFreteFinal) {

        return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);

    }
}
