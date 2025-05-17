package com.example.projeto_infomaz.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cadastro_produtos")
@Data @NoArgsConstructor @AllArgsConstructor
public class Produto {
    @Id
    private String id;

    @Column(nullable = false)
    private String categoria;

    @Column(name = "custo_unitario", nullable = false)
    private double custoUnitario;
}