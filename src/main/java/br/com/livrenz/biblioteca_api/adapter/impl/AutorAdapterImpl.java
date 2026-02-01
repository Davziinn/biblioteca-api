package br.com.livrenz.biblioteca_api.adapter.impl;

import br.com.livrenz.biblioteca_api.adapter.in.AutorAdapter;
import br.com.livrenz.biblioteca_api.mapper.in.AutorMapper;
import br.com.livrenz.biblioteca_api.model.Autor;
import br.com.livrenz.biblioteca_api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorAdapterImpl implements AutorAdapter {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private AutorMapper mapper;

    @Override
    public Autor salvarAutor(Autor autor) {
        return mapper.toModel(repository.save(mapper.toEntity(autor)));
    }
}
