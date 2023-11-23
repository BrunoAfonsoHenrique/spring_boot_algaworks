package com.algaworks.modelo.injecaodependencia.model;

public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo = false;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }


    public Boolean ativar() {
        return ativo = true;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
