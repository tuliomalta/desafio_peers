package com.example.projeto_infomaz.exception;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String id) {
        super("Produto não encontrado: " + id);
    }
}