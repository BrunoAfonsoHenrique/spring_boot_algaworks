package com.algaworks.algafood.model;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Restaurante {
    @Id
    private Long id;
    private String nome;
    @Column(
            name = "taxa_frete"
    )
    private BigDecimal taxaFrete;

    public Restaurante() {
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

    public BigDecimal getTaxaFrete() {
        return this.taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Restaurante that = (Restaurante)o;
            return Objects.equals(this.id, that.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }
}