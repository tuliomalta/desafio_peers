package com.example.projeto_infomaz.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<String> handleClienteNotFound(ClienteNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<String> handleProdutoNotFound(ProdutoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(FornecedorNotFoundException.class)
    public ResponseEntity<String> handleFornecedorNotFound(FornecedorNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EstoqueNotFoundException.class)
    public ResponseEntity<String> handleEstoqueNotFound(EstoqueNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TransacaoVendaNotFoundException.class)
    public ResponseEntity<String> handleTransacaoVendaNotFound(TransacaoVendaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
