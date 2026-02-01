package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.cliente.ClienteRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteController {

    @PostMapping
    void cadastrarCliente (@RequestBody ClienteRequestDTO requestDTO);
}
