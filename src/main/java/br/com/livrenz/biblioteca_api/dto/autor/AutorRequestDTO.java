package br.com.livrenz.biblioteca_api.dto.autor;

import br.com.livrenz.biblioteca_api.model.Livro;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorRequestDTO {

    private String nome;
    private List<Livro> livros;
}
