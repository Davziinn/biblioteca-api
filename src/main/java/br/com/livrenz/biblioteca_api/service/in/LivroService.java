package br.com.livrenz.biblioteca_api.service.in;

import br.com.livrenz.biblioteca_api.model.Livro;

import java.util.List;

public interface LivroService {

    Livro salvar (Livro livro);

    List<Livro> listarTodosOsLivros ();
}
