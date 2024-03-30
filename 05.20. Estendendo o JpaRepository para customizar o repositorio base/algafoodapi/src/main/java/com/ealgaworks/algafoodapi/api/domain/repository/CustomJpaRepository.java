package com.ealgaworks.algafoodapi.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean // Diz que essa interface não deve ser levada em conta como um repository
public interface CustomJpaRepository<T, D> extends JpaRepository<T, D> {

    Optional<T> buscarPrimeiro();
}
