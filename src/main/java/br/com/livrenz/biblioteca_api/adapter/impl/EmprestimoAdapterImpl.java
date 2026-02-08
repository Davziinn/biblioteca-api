package br.com.livrenz.biblioteca_api.adapter.impl;

import br.com.livrenz.biblioteca_api.adapter.in.EmprestimoAdapter;
import br.com.livrenz.biblioteca_api.mapper.in.EmprestimoMapper;
import br.com.livrenz.biblioteca_api.model.Emprestimo;
import br.com.livrenz.biblioteca_api.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoAdapterImpl implements EmprestimoAdapter {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private EmprestimoMapper mapper;

    @Override
    public Emprestimo salvar(Emprestimo emprestimo) {
        return mapper.toModel(repository.save(mapper.toEntity(emprestimo)));
    }
}
