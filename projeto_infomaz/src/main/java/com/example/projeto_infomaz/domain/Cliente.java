package com.example.projeto_infomaz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "cadastro_clientes")
@Data @NoArgsConstructor @AllArgsConstructor
public class Cliente {
    @Id
    private String id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Column(nullable = false)
    private String nome;
}