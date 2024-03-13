package com.ealgaworks.algafoodapi.api.domain.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
