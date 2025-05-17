package com.example.projeto_infomaz.repository;


import com.example.projeto_infomaz.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> { }
