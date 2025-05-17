package com.example.projeto_infomaz.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "cadastro_estoque")
@Data @NoArgsConstructor @AllArgsConstructor
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    @Column(name = "produto_id", nullable = false)
    private String produtoId;

    @Column(name = "fornecedor_id", nullable = false)
    private String fornecedorId;

    @Column(name = "quantidade_disponivel", nullable = false)
    private int quantidadeDisponivel;

    @Column(nullable = false)
    private LocalDate data;
}