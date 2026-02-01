package br.com.livrenz.biblioteca_api.controller.out;

import br.com.livrenz.biblioteca_api.dto.cliente.ClienteRequestDTO;
import br.com.livrenz.biblioteca_api.dto.cliente.ClienteResponseDTO;
import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.service.in.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody ClienteRequestDTO requestDTO) {
        ClienteResponseDTO clienteResponse = mapper.toResponseDTO(clienteService.cadastrarCliente(mapper.toModel(requestDTO)));

        return ResponseEntity.ok().body(clienteResponse);
    }
}
