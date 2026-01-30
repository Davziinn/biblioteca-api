package br.com.livrenz.biblioteca_api.mapper.in;

import br.com.livrenz.biblioteca_api.entity.ClienteEntity;
import br.com.livrenz.biblioteca_api.model.Cliente;

public interface ClienteMapper {

    Cliente toModel(ClienteEntity entity);

    ClienteEntity toEntity(Cliente model);
}
