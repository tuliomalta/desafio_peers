package com.example.projeto_infomaz.service;


import com.example.projeto_infomaz.domain.Fornecedor;
import com.example.projeto_infomaz.exception.FornecedorNotFoundException;
import com.example.projeto_infomaz.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FornecedorService {

    private final FornecedorRepository repo;

    public Fornecedor create(Fornecedor fornecedor) {
        return repo.save(fornecedor);
    }

    @Transactional(readOnly = true)
    public List<Fornecedor> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Fornecedor findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new FornecedorNotFoundException(id));
    }

    public Fornecedor update(String id, Fornecedor fornecedor) {
        Fornecedor existing = findById(id);
        if (fornecedor.getNome() != null) {
            existing.setNome(fornecedor.getNome());
        }
        return repo.save(existing);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}