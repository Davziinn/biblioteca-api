package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.autor.AutorRequestDTO;
import br.com.livrenz.biblioteca_api.dto.autor.AutorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AutorController {

    @PostMapping
    ResponseEntity<AutorResponseDTO> cadastrarAutor (@RequestBody AutorRequestDTO request);
}
