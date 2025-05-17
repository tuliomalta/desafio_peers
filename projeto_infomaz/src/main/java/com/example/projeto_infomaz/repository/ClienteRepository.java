package com.example.projeto_infomaz.repository;

import com.example.projeto_infomaz.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> { }
