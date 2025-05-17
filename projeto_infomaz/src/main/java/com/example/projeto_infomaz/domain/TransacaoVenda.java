package com.example.projeto_infomaz.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "transacoes_vendas")
@Data @NoArgsConstructor @AllArgsConstructor
public class TransacaoVenda {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    @Column(name = "produto_id", nullable = false)
    private String produtoId;

    @Column(name = "cliente_id", nullable = false)
    private String clienteId;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "valor_unitario_venda", nullable = false)
    private Double valorUnitarioVenda;
}