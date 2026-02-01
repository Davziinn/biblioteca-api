package br.com.livrenz.biblioteca_api.controller.out;

import br.com.livrenz.biblioteca_api.controller.in.LivroController;
import br.com.livrenz.biblioteca_api.dto.livro.LivroRequestDTO;
import br.com.livrenz.biblioteca_api.dto.livro.LivroResponseDTO;
import br.com.livrenz.biblioteca_api.mapper.in.LivroMapper;
import br.com.livrenz.biblioteca_api.service.in.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroRestController implements LivroController {

    @Autowired
    private LivroMapper mapper;

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> cadastrarLivro (@RequestBody LivroRequestDTO requestDTO) {
        LivroResponseDTO livroSalvo = mapper.toResponseDTO(service.salvar(mapper.toModel(requestDTO)));

        return ResponseEntity.ok().body(livroSalvo);
    }
}
