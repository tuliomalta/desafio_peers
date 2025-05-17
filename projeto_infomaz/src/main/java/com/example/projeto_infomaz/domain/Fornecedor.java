package com.example.projeto_infomaz.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cadastro_fornecedores")
@Data @NoArgsConstructor @AllArgsConstructor
public class Fornecedor {
    @Id
    private String id;

    @Column(nullable = false)
    private String nome;
}