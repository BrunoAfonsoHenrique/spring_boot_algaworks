package com.ealgaworks.algafoodapi.api.domain.repository;

import com.ealgaworks.algafoodapi.api.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    // List<Cozinha> nome(String nome); // Funciona -> Pesquisa exata (Super útil)

    /*
    List<Cozinha> findByNome(String nome); // prefixo -> findBy : O Spring entende que o que vem depois, ele precisa procurar na base
     */

    // List<Cozinha> findAllByNome(String nome);

//     List<Cozinha> findTodasByNome(String nome); // ignora a palavra que esta entre o "find" e o "By"
//
//    Optional<Cozinha> findByNome(String nome);

    List<Cozinha> findTodasByNomeContaining(String nome);

    Optional<Cozinha> findByNome(String nome);



}
