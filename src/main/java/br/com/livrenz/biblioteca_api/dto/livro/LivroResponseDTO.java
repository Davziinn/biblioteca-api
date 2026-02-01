package br.com.livrenz.biblioteca_api.dto.livro;


import br.com.livrenz.biblioteca_api.dto.autor.AutorResponseDTO;

import java.time.LocalDate;

public record LivroResponseDTO(

        Long id,
        String titulo,
        String descricao,
        Boolean identificadorDisponivel,
        LocalDate dataCriacao,
        LocalDate dataAtualizacao,
        AutorResponseDTO autor
) {
}
