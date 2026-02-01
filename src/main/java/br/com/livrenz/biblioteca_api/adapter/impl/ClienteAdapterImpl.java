package br.com.livrenz.biblioteca_api.adapter.impl;

import br.com.livrenz.biblioteca_api.adapter.in.ClienteAdapter;
import br.com.livrenz.biblioteca_api.entity.ClienteEntity;
import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.model.Cliente;
import br.com.livrenz.biblioteca_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteAdapterImpl implements ClienteAdapter {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return mapper.toModel(repository.save(mapper.toEntity(cliente)));
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long id) {
        Optional<ClienteEntity> clienteBuscadoPeloId = repository.findById(id);

        return clienteBuscadoPeloId.map(mapper::toModel);
    }

    @Override
    public List<Cliente> listarTodosCliente() {
        return repository.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }


    @Override
    public Optional<Cliente> buscarClientePorCpf(String cpf) {
        Optional<ClienteEntity> clienteBuscadoPeloCpf = repository.findByCpf(cpf);

        return clienteBuscadoPeloCpf.map(mapper::toModel);
    }
}
