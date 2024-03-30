package com.ealgaworks.algafoodapi.api.domain.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {



}
