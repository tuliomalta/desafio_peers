package com.example.projeto_infomaz.controller;


import com.example.projeto_infomaz.domain.Estoque;
import com.example.projeto_infomaz.service.EstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoques")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService service;

    @PostMapping
    public ResponseEntity<Estoque> create(@RequestBody Estoque estoque) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(estoque));
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{seq}")
    public ResponseEntity<Estoque> findById(@PathVariable Long seq) {
        return ResponseEntity.ok(service.findById(seq));
    }

    @PutMapping("/{seq}")
    public ResponseEntity<Estoque> update(
            @PathVariable Long seq,
            @RequestBody Estoque estoque) {
        return ResponseEntity.ok(service.update(seq, estoque));
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> delete(@PathVariable Long seq) {
        service.delete(seq);
        return ResponseEntity.noContent().build();
    }
}

