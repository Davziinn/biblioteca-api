package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.cliente.ClienteRequestDTO;
import br.com.livrenz.biblioteca_api.dto.cliente.ClienteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteController {

    @PostMapping
    ResponseEntity<ClienteResponseDTO> cadastrarCliente (@RequestBody ClienteRequestDTO requestDTO);

    @GetMapping("/{id}")
    ResponseEntity<ClienteResponseDTO> buscarClientePorId (@PathVariable Long id);
}
