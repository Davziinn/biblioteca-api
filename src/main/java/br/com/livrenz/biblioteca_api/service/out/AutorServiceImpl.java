package br.com.livrenz.biblioteca_api.service.out;

import br.com.livrenz.biblioteca_api.adapter.in.AutorAdapter;
import br.com.livrenz.biblioteca_api.mapper.in.AutorMapper;
import br.com.livrenz.biblioteca_api.model.Autor;
import br.com.livrenz.biblioteca_api.service.in.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorAdapter repository;

    @Autowired
    private AutorMapper mapper;

    @Override
    public Autor salvar(Autor autor) {
        return repository.salvarAutor(autor);
    }
}
