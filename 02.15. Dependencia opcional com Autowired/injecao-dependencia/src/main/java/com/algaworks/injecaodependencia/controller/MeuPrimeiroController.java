package com.algaworks.injecaodependencia.controller;


import com.algaworks.injecaodependencia.model.Cliente;
import com.algaworks.injecaodependencia.service.AtivacaoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    @Autowired
    private AtivacaoClienteService ativacaoClienteService;

//    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
//        this.ativacaoClienteService = ativacaoClienteService;
//
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("Joao", "joao@gmail.com", "11122233344");
        ativacaoClienteService.ativar(joao);
        return "Hello!";
    }

}