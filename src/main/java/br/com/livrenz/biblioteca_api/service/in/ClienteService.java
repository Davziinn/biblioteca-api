package br.com.livrenz.biblioteca_api.service.in;

import br.com.livrenz.biblioteca_api.model.Cliente;

import java.util.List;


public interface ClienteService {
    Cliente cadastrarCliente (Cliente cliente);

    Cliente buscarClienteById (Long id);

    List<Cliente> buscarTodosOsClientes();

    Cliente editarCliente (Long id, Cliente cliente);

    void deletarCliente (Long id);
}
