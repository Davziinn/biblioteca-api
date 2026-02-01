package br.com.livrenz.biblioteca_api.adapter.in;

import br.com.livrenz.biblioteca_api.model.Autor;

import java.util.Optional;

public interface AutorAdapter {
    Autor salvarAutor (Autor autor);

    Optional<Autor> buscarAutorPeloId (Long id);
}
