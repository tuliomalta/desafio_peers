package com.example.projeto_infomaz.exception;

public class FornecedorNotFoundException extends RuntimeException {
    public FornecedorNotFoundException(String id) {
        super("Fornecedor não encontrado: " + id);
    }
}
