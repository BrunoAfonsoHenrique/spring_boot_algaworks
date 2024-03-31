package com.ealgaworks.algafoodapi.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    // @JsonIgnore // Evita referencia circular
    @OneToMany(mappedBy = "cozinha") // Uma zinha tem muitos restaurantes // Many indica que é uma coleção
    private List<Restaurante> restaurantes = new ArrayList<>();

    /*
        O dono da relação é a tabela de Restaurante
     */

}
