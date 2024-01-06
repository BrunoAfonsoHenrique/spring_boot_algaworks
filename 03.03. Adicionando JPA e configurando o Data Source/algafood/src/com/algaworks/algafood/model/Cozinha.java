package com.algaworks.algafood.model;

import java.util.Objects;

@Entity
@Table(
        name = "Cozinha"
)
public class Cozinha {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "nome"
    )
    private String nome;

    public Cozinha() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Cozinha cozinha = (Cozinha)o;
            return Objects.equals(this.id, cozinha.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }
}