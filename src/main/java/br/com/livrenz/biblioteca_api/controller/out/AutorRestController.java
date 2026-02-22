package br.com.livrenz.biblioteca_api.controller.out;

import br.com.livrenz.biblioteca_api.controller.in.AutorController;
import br.com.livrenz.biblioteca_api.dto.autor.AutorRequestDTO;
import br.com.livrenz.biblioteca_api.dto.autor.AutorResponseDTO;
import br.com.livrenz.biblioteca_api.mapper.in.AutorMapper;
import br.com.livrenz.biblioteca_api.service.in.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorRestController implements AutorController {

    @Autowired
    private AutorService service;

    @Autowired
    private AutorMapper mapper;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> cadastrarAutor (@RequestBody AutorRequestDTO request) {
        AutorResponseDTO autorCadastrado = mapper.toResponseDTO(service.salvar(mapper.toModel(request)));

        return ResponseEntity.ok().body(autorCadastrado);
    }
}
