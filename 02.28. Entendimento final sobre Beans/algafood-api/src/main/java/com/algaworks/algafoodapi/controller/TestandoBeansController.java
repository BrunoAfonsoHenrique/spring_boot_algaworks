package com.algaworks.algafoodapi.controller;


import com.algaworks.algafoodapi.model.Cliente;
import com.algaworks.algafoodapi.service.AtivacaoClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestandoBeansController {

    AtivacaoClienteService ativacaoClienteService;

    public TestandoBeansController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;

    }
    @GetMapping("/hello")
    @ResponseBody
    public String OlaMundo() {
        Cliente joao = new Cliente("Joao", "joao@gmail.com", "11122233344");
        ativacaoClienteService.ativarCliente(joao);
        return "Ola, mundo";
    }
}
