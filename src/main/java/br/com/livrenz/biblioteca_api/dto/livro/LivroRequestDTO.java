package br.com.livrenz.biblioteca_api.dto.livro;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroRequestDTO {

    private String titulo;
    private String descricao;
    private Boolean identificadorDisponivel;
    private Long autorId;
}
