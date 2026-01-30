package br.com.livrenz.biblioteca_api.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataCriacao;
}
