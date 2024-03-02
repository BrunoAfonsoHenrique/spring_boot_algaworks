package com.ealgaworks.algafoodapi.api.domain.controller;

import com.ealgaworks.algafoodapi.api.domain.exceptions.EntidadeNaoEncontradaException;
import com.ealgaworks.algafoodapi.api.domain.model.Restaurante;
import com.ealgaworks.algafoodapi.api.domain.service.RestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @GetMapping
    public List<Restaurante> listar() {
        return service.listar();
    }


    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long restauranteId) {
        Restaurante restaurante = service.buscarRestauranteId(restauranteId);
        return ResponseEntity.status(HttpStatus.FOUND).body(restaurante);

    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {

            restaurante = service.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/atualizar/{restauranteId}")
    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId,
                                       @RequestBody Restaurante restaurante) {

        try {
            Restaurante restauranteAtual = service.buscarRestauranteId(restauranteId);

            if (restauranteAtual != null) {
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

                restauranteAtual = service.salvar(restauranteAtual);
                return ResponseEntity.ok(restauranteAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

//    @PatchMapping("/atualizar-parcial/{restauranteId}")
//    public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId,
//                                              @RequestBody Map<String, Object> campos) {
//
//        Restaurante restauranteAtual = service.buscarRestauranteId(restauranteId);
//
//        if (restauranteAtual == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        merge(campos, restauranteAtual);
//
//        return atualizar(restauranteId, restauranteAtual);
//
//    }
//
//    private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
//
//        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
//            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
//            field.setAccessible(true);
//
//            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
//
////			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);
//
//            ReflectionUtils.setField(field, restauranteDestino, novoValor);
//        });
//    }

}
