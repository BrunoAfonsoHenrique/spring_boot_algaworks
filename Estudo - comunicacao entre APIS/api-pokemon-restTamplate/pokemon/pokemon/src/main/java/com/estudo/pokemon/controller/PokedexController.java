package com.estudo.pokemon.controller;


import com.estudo.pokemon.model.entities.Pokedex;
import com.estudo.pokemon.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokedex/api/v1")
public class PokedexController {

    @Autowired
    PokedexService pokedexService;

    @GetMapping
    public Pokedex listarTodosPokemons() {
        return pokedexService.getPokedex();
    }
}
