package br.com.livrenz.biblioteca_api.model;

import br.com.livrenz.biblioteca_api.entity.AutorEntity;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Livro {

    private Long id;
    private String titulo;
    private String descricao;
    private Boolean identificadorDisponivel;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;
    private AutorEntity autor;
}
