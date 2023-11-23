package com.algaworks.pokemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @GetMapping("/charmander")
    @ResponseBody
    public String identificarPokemon() {
        return "Esse pokemon é um Charmander";
    }

    /*
        TODO RestController -> Informa que a classe é um controller
        TODO RequestMapping("/pokemon") ->  Mapeamento básico para todas as URLs neste controller.
        TODO GetMapping("/charmander") -> Acionará o método para buscar algo que você define.
        TODO ResponseBody -> Retorno do métoda torna-se a resposta da requisição.
     */
}
