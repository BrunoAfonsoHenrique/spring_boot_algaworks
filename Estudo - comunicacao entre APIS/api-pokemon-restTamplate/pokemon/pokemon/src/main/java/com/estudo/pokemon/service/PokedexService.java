package com.estudo.pokemon.service;

import com.estudo.pokemon.model.entities.Pokedex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokedexService {

    @Autowired RestTemplate restTemplate;

    public Pokedex getPokedex() {
        Pokedex pokedexBuscada = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon?offset=10&limit=10", Pokedex.class);
        return pokedexBuscada;
    }

}
