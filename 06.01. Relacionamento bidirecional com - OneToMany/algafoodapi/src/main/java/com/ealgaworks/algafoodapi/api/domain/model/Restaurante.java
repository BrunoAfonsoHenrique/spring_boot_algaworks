package com.ealgaworks.algafoodapi.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @JsonIgnore
    @ManyToOne // Muitos restaurantes padem ter uma cozinha
    @JoinColumn(name = "cozinha_id", nullable = false)
    private Cozinha cozinha;

    /*
        O dono da relação é a tabela de Restaurante
     */

}
