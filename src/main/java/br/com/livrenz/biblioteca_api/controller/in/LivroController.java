package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.livro.LivroRequestDTO;
import br.com.livrenz.biblioteca_api.dto.livro.LivroResponseDTO;
import br.com.livrenz.biblioteca_api.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface LivroController {

    @PostMapping
    ResponseEntity<LivroResponseDTO> cadastrarLivro (@RequestBody LivroRequestDTO requestDTO);

    @GetMapping
    ResponseEntity<List<LivroResponseDTO>> buscarLivros ();

    @GetMapping("/{titulo}")
    ResponseEntity<List<Livro>>  buscarLivroPeloTitulo (@PathVariable String titulo);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarLivroPorId (@PathVariable Long id);
}
