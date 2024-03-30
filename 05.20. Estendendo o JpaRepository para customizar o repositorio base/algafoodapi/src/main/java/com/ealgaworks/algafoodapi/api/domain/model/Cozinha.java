package com.ealgaworks.algafoodapi.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Entity
@Table(name = "Cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("titulo")
    @Column(name = "nome", nullable = false)
    private String nome;

}
