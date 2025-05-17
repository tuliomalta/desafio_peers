package com.example.projeto_infomaz.repository;

import com.example.projeto_infomaz.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> { }
