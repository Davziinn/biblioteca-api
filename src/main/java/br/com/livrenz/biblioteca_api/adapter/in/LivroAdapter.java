package br.com.livrenz.biblioteca_api.adapter.in;


import br.com.livrenz.biblioteca_api.model.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroAdapter {
    Livro salvarLivro (Livro livro);

    List<Livro> buscarTodosOsLivros();

    Optional<List<Livro>> buscarLivroByTitulo (String titulo);

    Optional<Livro> buscarLivroById (Long id);

    void deletarLivroById (Long id);
}
