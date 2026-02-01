package br.com.livrenz.biblioteca_api.adapter.in;

import br.com.livrenz.biblioteca_api.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteAdapter {

    Cliente salvarCliente (Cliente cliente);

    Optional<Cliente> buscarClientePorId (Long id);

    List<Cliente> listarTodosCliente();

    Optional<Cliente> buscarClientePorCpf (String cpf);

    void deletarClientePorId (Long id);
}
