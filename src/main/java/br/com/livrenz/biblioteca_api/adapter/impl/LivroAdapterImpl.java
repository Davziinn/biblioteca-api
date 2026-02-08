package br.com.livrenz.biblioteca_api.adapter.impl;

import br.com.livrenz.biblioteca_api.adapter.in.LivroAdapter;
import br.com.livrenz.biblioteca_api.entity.LivroEntity;
import br.com.livrenz.biblioteca_api.mapper.in.LivroMapper;
import br.com.livrenz.biblioteca_api.model.Livro;
import br.com.livrenz.biblioteca_api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LivroAdapterImpl implements LivroAdapter {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroMapper mapper;

    @Override
    public Livro salvarLivro(Livro livro) {
        return mapper.toModel(repository.save(mapper.toEntity(livro)));
    }

    @Override
    public List<Livro> buscarTodosOsLivros() {
        return repository.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Optional<List<Livro>> buscarLivroByTitulo(String titulo) {
        // Busca a lista no repositório
        List<LivroEntity> livrosEncontrados = repository.findByTitulo(titulo);

        List<Livro> modelos = livrosEncontrados.stream()
                .map(entity -> mapper.toModel(entity))
                .toList();

        return Optional.of(modelos);
    }

    @Override
    public void deletarLivroById(Long id) {
        repository.deleteById(id);
    }
}
