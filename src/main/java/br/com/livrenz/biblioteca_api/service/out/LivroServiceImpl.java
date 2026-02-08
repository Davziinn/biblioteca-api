package br.com.livrenz.biblioteca_api.service.out;

import br.com.livrenz.biblioteca_api.adapter.in.AutorAdapter;
import br.com.livrenz.biblioteca_api.adapter.in.LivroAdapter;
import br.com.livrenz.biblioteca_api.exceptions.AutorNotFoundException;
import br.com.livrenz.biblioteca_api.exceptions.LivroNotFoundException;
import br.com.livrenz.biblioteca_api.mapper.in.LivroMapper;
import br.com.livrenz.biblioteca_api.model.Autor;
import br.com.livrenz.biblioteca_api.model.Livro;
import br.com.livrenz.biblioteca_api.service.in.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroAdapter livroRepository;

    @Autowired
    private AutorAdapter autorRepository;

    @Autowired
    private LivroMapper mapper;

    @Override
    public Livro salvar(Livro livro) {
        Autor autorBuscado = autorRepository.buscarAutorPeloId(livro.getAutor().getId())
                .orElseThrow(
                        () -> new AutorNotFoundException("Autor não encontrado")
                );

        Livro livroDoAutor = livro.toBuilder()
                .autor(autorBuscado)
                .build();

        return livroRepository.salvarLivro(livroDoAutor);
    }

    @Override
    public List<Livro> listarTodosOsLivros() {
        return livroRepository.buscarTodosOsLivros().stream()
                .filter(Livro::getIdentificadorDisponivel)
                .toList();
    }

    @Override
    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        List<Livro> livros = livroRepository.buscarLivroByTitulo(titulo)
                .orElseThrow(
                        () -> new LivroNotFoundException("Livro indisponível ou não encontrado")
                );

        return livros.stream()
                .filter(Livro::getIdentificadorDisponivel)
                .toList();
    }

    @Override
    public void deletarLivro(Long id) {
        livroRepository.deletarLivroById(id);
    }


}
