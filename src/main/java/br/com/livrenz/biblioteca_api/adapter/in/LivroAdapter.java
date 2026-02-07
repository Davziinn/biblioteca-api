package br.com.livrenz.biblioteca_api.adapter.in;


import br.com.livrenz.biblioteca_api.model.Livro;

import java.util.List;

public interface LivroAdapter {
    Livro salvarLivro (Livro livro);

    List<Livro> buscarTodosOsLivros();
}
