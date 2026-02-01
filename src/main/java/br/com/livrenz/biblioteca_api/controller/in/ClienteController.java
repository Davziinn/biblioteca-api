package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.cliente.ClienteRequestDTO;
import br.com.livrenz.biblioteca_api.dto.cliente.ClienteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClienteController {

    @PostMapping
    ResponseEntity<ClienteResponseDTO> cadastrarCliente (@RequestBody ClienteRequestDTO requestDTO);

    @GetMapping("/{id}")
    ResponseEntity<ClienteResponseDTO> buscarClientePorId (@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<ClienteResponseDTO>> listarTodosOsCliente();

    @PutMapping("/{id}")
    ResponseEntity<ClienteResponseDTO> editarCliente (@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarCliente (@PathVariable Long id);
}
