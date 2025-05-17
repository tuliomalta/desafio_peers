package com.example.projeto_infomaz.service;

import com.example.projeto_infomaz.domain.TransacaoVenda;
import com.example.projeto_infomaz.exception.TransacaoVendaNotFoundException;
import com.example.projeto_infomaz.repository.TransacaoVendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TransacaoVendaService {

    private final TransacaoVendaRepository repo;

    public TransacaoVenda create(TransacaoVenda tv) {
        return repo.save(tv);
    }

    @Transactional(readOnly = true)
    public List<TransacaoVenda> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public TransacaoVenda findById(Long seq) {
        return repo.findById(seq)
                .orElseThrow(() -> new TransacaoVendaNotFoundException(seq));
    }

    public TransacaoVenda update(Long seq, TransacaoVenda tv) {
        TransacaoVenda existing = findById(seq);
        if (tv.getProdutoId() != null) {
            existing.setProdutoId(tv.getProdutoId());
        }
        if (tv.getClienteId() != null) {
            existing.setClienteId(tv.getClienteId());
        }
        if (tv.getData() != null) {
            existing.setData(tv.getData());
        }
        if (tv.getQuantidade() != null) {
            existing.setQuantidade(tv.getQuantidade());
        }
        if (tv.getValorUnitarioVenda() != null) {
            existing.setValorUnitarioVenda(tv.getValorUnitarioVenda());
        }
        return repo.save(existing);
    }

    public void delete(Long seq) {
        repo.deleteById(seq);
    }
}