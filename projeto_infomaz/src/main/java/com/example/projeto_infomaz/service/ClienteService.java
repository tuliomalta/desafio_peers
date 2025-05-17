package com.example.projeto_infomaz.service;


import com.example.projeto_infomaz.domain.Cliente;
import com.example.projeto_infomaz.exception.ClienteNotFoundException;
import com.example.projeto_infomaz.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteService {

    private final ClienteRepository repo;

    public Cliente create(Cliente cliente) {
        return repo.save(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public Cliente update(String id, Cliente cliente) {
        Cliente existing = findById(id);
        if (cliente.getNome() != null) {
            existing.setNome(cliente.getNome());
        }
        return repo.save(existing);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}