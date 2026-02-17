package br.com.livrenz.biblioteca_api.adapter.in;

import br.com.livrenz.biblioteca_api.model.Emprestimo;

import java.util.Optional;

public interface EmprestimoAdapter {
    Emprestimo salvar(Emprestimo emprestimo);

    Optional<Emprestimo> buscarEmprestimoById (Long id);
}
