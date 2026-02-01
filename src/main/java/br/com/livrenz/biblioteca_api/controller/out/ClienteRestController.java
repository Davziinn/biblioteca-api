package br.com.livrenz.biblioteca_api.controller.out;

import br.com.livrenz.biblioteca_api.controller.in.ClienteController;
import br.com.livrenz.biblioteca_api.dto.cliente.ClienteRequestDTO;
import br.com.livrenz.biblioteca_api.dto.cliente.ClienteResponseDTO;
import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.service.in.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController implements ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@Valid @RequestBody ClienteRequestDTO requestDTO) {
        ClienteResponseDTO clienteResponse = mapper.toResponseDTO(clienteService.cadastrarCliente(mapper.toModel(requestDTO)));

        return ResponseEntity.ok().body(clienteResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarClientePorId(Long id) {
        ClienteResponseDTO clienteResponseBuscado = mapper.toResponseDTO(clienteService.buscarClienteById(id));

        return ResponseEntity.status(HttpStatus.FOUND).body(clienteResponseBuscado);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodosOsCliente() {
        List<ClienteResponseDTO> listaDeClientesCadastrados = clienteService.buscarTodosOsClientes().stream()
                .map(mapper::toResponseDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(listaDeClientesCadastrados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> editarCliente (@Valid @PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
       ClienteResponseDTO clienteEditado = mapper.toResponseDTO(clienteService.editarCliente(id, mapper.toModel(clienteRequestDTO)));

        return ResponseEntity.ok().body(clienteEditado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente (@PathVariable Long id) {
        clienteService.deletarCliente(id);

        return ResponseEntity.noContent().build();
    }
}
