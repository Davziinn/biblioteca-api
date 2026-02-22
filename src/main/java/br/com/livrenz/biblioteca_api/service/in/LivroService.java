package br.com.livrenz.biblioteca_api.service.in;

import br.com.livrenz.biblioteca_api.model.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroService {

    Livro salvar (Livro livro);

    List<Livro> listarTodosOsLivros ();

    List<Livro> buscarLivrosPorTitulo (String titulo);

    void deletarLivro (Long id);

    Livro setarLivroComoIndisponivel(Livro livro);

    List<Livro> buscarLivrosPorAutorId(Long autorId);
}
