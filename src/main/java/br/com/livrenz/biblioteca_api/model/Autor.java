package br.com.livrenz.biblioteca_api.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Autor {


    private Long id;
    private String nome;
    private List<Livro> livros;
    private LocalDate dataCriacao;
}
