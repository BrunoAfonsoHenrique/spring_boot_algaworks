package com.algaworks.algafoodapi.model;

public class Cliente {

    private String nome;

    private String telefone;

    private String email;

    private Boolean ativo = false;

    public Cliente(String name, String telefone, String email) {
        this.nome = name;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void ativar() {
        this.ativo = true;
    }

}
