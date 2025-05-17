package com.example.projeto_infomaz.exception;

public class TransacaoVendaNotFoundException extends RuntimeException {
    public TransacaoVendaNotFoundException(Long seq) {
        super("Transação não encontrada: " + seq);
    }
}
