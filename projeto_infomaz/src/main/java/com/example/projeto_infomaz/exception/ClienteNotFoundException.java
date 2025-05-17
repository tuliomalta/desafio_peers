package com.example.projeto_infomaz.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String id) {
        super("Cliente não encontrado: " + id);
    }
}