package br.com.livrenz.biblioteca_api.dto.emprestimo;

import br.com.livrenz.biblioteca_api.dto.cliente.ClienteResponseDTO;
import br.com.livrenz.biblioteca_api.dto.livro.LivroResponseDTO;
import br.com.livrenz.biblioteca_api.enums.StatusEmprestimo;

import java.time.LocalDate;

public record EmprestimoResponseDTO(

        Long id,
        ClienteResponseDTO cliente,
        LivroResponseDTO livro,
        StatusEmprestimo statusEmprestimo,
        LocalDate dataEmprestimo,
        LocalDate dataPrevistaDevolucao,
        LocalDate dataDevolucao
) {
}
