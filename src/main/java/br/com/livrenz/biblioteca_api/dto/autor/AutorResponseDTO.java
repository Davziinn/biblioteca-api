package br.com.livrenz.biblioteca_api.dto.autor;

import br.com.livrenz.biblioteca_api.model.Livro;

import java.time.LocalDateTime;
import java.util.List;

public record AutorResponseDTO (
        Long id,
        String nome,
        List<Livro> livros,
        LocalDateTime dataCriacao
) {}
