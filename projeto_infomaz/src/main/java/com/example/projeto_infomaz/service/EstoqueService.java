package com.example.projeto_infomaz.service;


import com.example.projeto_infomaz.domain.Estoque;
import com.example.projeto_infomaz.exception.EstoqueNotFoundException;
import com.example.projeto_infomaz.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EstoqueService {

    private final EstoqueRepository repo;

    public Estoque create(Estoque estoque) {
        return repo.save(estoque);
    }

    @Transactional(readOnly = true)
    public List<Estoque> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Estoque findById(Long seq) {
        return repo.findById(seq)
                .orElseThrow(() -> new EstoqueNotFoundException(seq));
    }

    public Estoque update(Long seq, Estoque estoque) {
        Estoque existing = findById(seq);
        if (estoque.getProdutoId() != null) {
            existing.setProdutoId(estoque.getProdutoId());
        }
        if (estoque.getFornecedorId() != null) {
            existing.setFornecedorId(estoque.getFornecedorId());
        }
        if (estoque.getQuantidadeDisponivel() != null) {
            existing.setQuantidadeDisponivel(estoque.getQuantidadeDisponivel());
        }
        if (estoque.getData() != null) {
            existing.setData(estoque.getData());
        }
        return repo.save(existing);
    }

    public void delete(Long seq) {
        repo.deleteById(seq);
    }
}