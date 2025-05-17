package com.example.projeto_infomaz.controller;


import com.example.projeto_infomaz.domain.Produto;
import com.example.projeto_infomaz.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(
            @PathVariable String id,
            @RequestBody Produto produto) {
        return ResponseEntity.ok(service.update(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

