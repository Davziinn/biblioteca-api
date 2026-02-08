package br.com.livrenz.biblioteca_api.model;

import br.com.livrenz.biblioteca_api.enums.StatusEmprestimo;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Emprestimo {

    private Long id;
    private Cliente cliente;
    private Livro livro;
    private StatusEmprestimo statusEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}
