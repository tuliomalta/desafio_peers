package com.example.projeto_infomaz.exception;

public class EstoqueNotFoundException extends RuntimeException {
    public EstoqueNotFoundException(Long seq) {
        super("Estoque não encontrado: " + seq);
    }
}