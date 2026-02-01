package br.com.livrenz.biblioteca_api.service.out;

import br.com.livrenz.biblioteca_api.adapter.in.ClienteAdapter;
import br.com.livrenz.biblioteca_api.exceptions.ClienteJaExisteException;
import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.model.Cliente;
import br.com.livrenz.biblioteca_api.service.in.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
