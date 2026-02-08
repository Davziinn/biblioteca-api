package br.com.livrenz.biblioteca_api.dto.emprestimo;

import br.com.livrenz.biblioteca_api.enums.StatusEmprestimo;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmprestimoRequestDTO {

    private String nome;
    private String cpf;
    private String titulo;
    private StatusEmprestimo statusEmprestimo;
}
