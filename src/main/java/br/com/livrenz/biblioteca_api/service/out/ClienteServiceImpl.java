package br.com.livrenz.biblioteca_api.service.out;

import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.model.Cliente;
import br.com.livrenz.biblioteca_api.repository.ClienteRepository;
import br.com.livrenz.biblioteca_api.service.in.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        return mapper.toModel(repository.save(mapper.toEntity(cliente)));
    }
}
