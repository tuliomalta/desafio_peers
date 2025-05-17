package com.example.projeto_infomaz.controller;


import com.example.projeto_infomaz.domain.Fornecedor;
import com.example.projeto_infomaz.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorService service;

    @PostMapping
    public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(fornecedor));
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(
            @PathVariable String id,
            @RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(service.update(id, fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

