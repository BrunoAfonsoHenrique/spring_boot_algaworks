package com.ealgaworks.algafoodapi.api.domain.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }


    public EntidadeNaoEncontradaException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
