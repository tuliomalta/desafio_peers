package com.example.projeto_infomaz.controller;


import com.example.projeto_infomaz.domain.Cliente;
import com.example.projeto_infomaz.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(
            @PathVariable String id,
            @RequestBody Cliente cliente) {
        return ResponseEntity.ok(service.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
