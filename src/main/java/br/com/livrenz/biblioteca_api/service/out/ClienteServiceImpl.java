package br.com.livrenz.biblioteca_api.service.out;

import br.com.livrenz.biblioteca_api.adapter.in.ClienteAdapter;
import br.com.livrenz.biblioteca_api.exceptions.ClienteJaExisteException;
import br.com.livrenz.biblioteca_api.exceptions.ClienteNotFoundException;
import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.model.Cliente;
import br.com.livrenz.biblioteca_api.service.in.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteAdapter repository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        Optional<Cliente> clienteBuscado = repository.buscarClientePorCpf(cliente.getCpf());

        if (clienteBuscado.isPresent()) {
            throw new ClienteJaExisteException("Cliente já cadastrado");
        }

        return repository.salvarCliente(cliente);

    }

    @Override
    public Cliente buscarClienteById(Long id) {
        return repository.buscarClientePorId(id).orElseThrow(
                () -> new ClienteNotFoundException("Cliente não encontrado")
        );
    }

    @Override
    public List<Cliente> buscarTodosOsClientes() {
        return repository.listarTodosCliente();
    }

    @Override
    public Cliente editarCliente(Long id, Cliente cliente) {
        Cliente clienteBuscado = repository.buscarClientePorId(id)
                .orElseThrow(
                        () -> new ClienteNotFoundException("Cliente não encontrado")
                );

        repository.buscarClientePorCpf(cliente.getCpf()).ifPresent(clienteComMesmoCpf -> {
            if (!clienteComMesmoCpf.getId().equals(id)) {
                throw new ClienteJaExisteException("Erro: O CPF [" + cliente.getCpf() + "] já pertence a outro cliente.");
            }
        });

        Cliente clienteAtualizado = clienteBuscado.toBuilder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();

        return repository.salvarCliente(clienteAtualizado);
    }
}
