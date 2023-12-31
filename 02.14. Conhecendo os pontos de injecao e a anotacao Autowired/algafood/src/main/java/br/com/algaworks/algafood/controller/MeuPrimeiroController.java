package br.com.algaworks.algafood.controller;

import br.com.algaworks.algafood.model.Cliente;
import br.com.algaworks.algafood.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;

    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("Joao", "joao@gmail.com", "11122233344");
        ativacaoClienteService.ativar(joao);
        return "Hello!";
    }

}