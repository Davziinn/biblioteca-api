package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.livro.LivroRequestDTO;
import br.com.livrenz.biblioteca_api.dto.livro.LivroResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LivroController {

    @PostMapping
    ResponseEntity<LivroResponseDTO> cadastrarLivro (@RequestBody LivroRequestDTO requestDTO);

    @GetMapping
    ResponseEntity<List<LivroResponseDTO>> buscarLivros ();
}
