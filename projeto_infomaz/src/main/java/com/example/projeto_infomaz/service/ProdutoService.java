package com.example.projeto_infomaz.service;


import com.example.projeto_infomaz.domain.Produto;
import com.example.projeto_infomaz.exception.ProdutoNotFoundException;
import com.example.projeto_infomaz.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProdutoService {

    private final ProdutoRepository repo;

    public Produto create(Produto produto) {
        return repo.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Produto findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    public Produto update(String id, Produto produto) {
        Produto existing = findById(id);
        if (produto.getCategoria() != null) {
            existing.setCategoria(produto.getCategoria());
        }
        if (produto.getCustoUnitario() != null) {
            existing.setCustoUnitario(produto.getCustoUnitario());
        }
        return repo.save(existing);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}