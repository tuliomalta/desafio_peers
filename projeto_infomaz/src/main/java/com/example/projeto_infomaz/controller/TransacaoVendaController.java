package com.example.projeto_infomaz.controller;


import com.example.projeto_infomaz.domain.TransacaoVenda;
import com.example.projeto_infomaz.service.TransacaoVendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@RequiredArgsConstructor
public class TransacaoVendaController {

    private final TransacaoVendaService service;

    @PostMapping
    public ResponseEntity<TransacaoVenda> create(@RequestBody TransacaoVenda tv) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(tv));
    }

    @GetMapping
    public ResponseEntity<List<TransacaoVenda>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{seq}")
    public ResponseEntity<TransacaoVenda> findById(@PathVariable Long seq) {
        return ResponseEntity.ok(service.findById(seq));
    }

    @PutMapping("/{seq}")
    public ResponseEntity<TransacaoVenda> update(
            @PathVariable Long seq,
            @RequestBody TransacaoVenda tv) {
        return ResponseEntity.ok(service.update(seq, tv));
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> delete(@PathVariable Long seq) {
        service.delete(seq);
        return ResponseEntity.noContent().build();
    }
}
