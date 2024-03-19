package br.com.algaworks.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.algaworks.consumer.model.ProdutoComPreco;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class PrecoProdutoService {

	@Autowired
	private WebClient webClientProdutos;

	@Autowired
	private WebClient webClientPrecos;

	//TODO
	public ProdutoComPreco obterPorCodigo(Long codigoProduto) {
		//Mono -> nos da uma série de métodos que nos permite tratar o retorno quando a requisição finalizar sem bloquear o nosso método
		Mono<ProdutoComPreco> monoProduto =
				webClientProdutos.method(HttpMethod.GET)
				.uri("/produtos/{codigo}", codigoProduto)
				.retrieve() // O método retrieve dispara a requisição HTTP
				.bodyToMono(ProdutoComPreco.class); // tipo do objeto que queremos de retorno

//		monoProduto.subscribe(p -> {
//			System.out.println("Aqui sim, finalizou de verdade"); // Subscribe -> fica esperando até que o produto seja retornado
//		});

//		System.out.println("Finalizou");

		Mono<ProdutoComPreco> monoPreco =
				webClientPrecos.method(HttpMethod.GET)
				.uri("/precos/{codigoProduto}", codigoProduto)
				.retrieve()
				.bodyToMono(ProdutoComPreco.class);


//		ProdutoComPreco produto = monoProduto.block();
//		ProdutoComPreco preco = monoPreco.block();
//		produto.setPreco(preco.getPreco());

		ProdutoComPreco produtoComPreco = Mono.zip(monoProduto, monoPreco).map(tuple -> {
			tuple.getT1().setPreco(tuple.getT2().getPreco());
			return tuple.getT1();
		}).block();
		/*
		 zip -> passa todos os monos que recebemos;
		 map -> me da acesso a todas as respostas de todas as requisições, ae posso montar um objeto e retornar.
		 */

		ProdutoComPreco produtoComPreco1 = new ProdutoComPreco(5L, "Violao", new BigDecimal(50));
		Mono<ProdutoComPreco> monoProduto1 =
				webClientProdutos.post()
						.uri("/produtos/")
						.body(BodyInserters.fromValue(produtoComPreco1)) // BodyInserters -> pega o corpo/body
						.retrieve()
						.bodyToMono(ProdutoComPreco.class);


		// return produtoComPreco;
		return monoProduto1.block();
	}
}
