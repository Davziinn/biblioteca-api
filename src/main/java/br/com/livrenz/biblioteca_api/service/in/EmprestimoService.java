package br.com.livrenz.biblioteca_api.service.in;

import br.com.livrenz.biblioteca_api.model.Emprestimo;

public interface EmprestimoService {
    Emprestimo salvarEmprestimo(Emprestimo emprestimo);

    Emprestimo consultarEmprestimo(Long id);
}
