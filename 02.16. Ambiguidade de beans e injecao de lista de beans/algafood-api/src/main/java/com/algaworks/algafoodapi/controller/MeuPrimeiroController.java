package com.algaworks.algafoodapi.controller;

import com.algaworks.algafoodapi.model.Cliente;
import com.algaworks.algafoodapi.service.AtivacaoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    @Autowired
    private AtivacaoClienteService ativacaoClienteService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("Joao", "joao@gmail.com", "11122233344");
        ativacaoClienteService.ativar(joao);
        return "Hello!";
    }

}