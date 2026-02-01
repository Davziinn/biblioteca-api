package br.com.livrenz.biblioteca_api.mapper.out;

import br.com.livrenz.biblioteca_api.dto.cliente.ClienteRequestDTO;
import br.com.livrenz.biblioteca_api.dto.cliente.ClienteResponseDTO;
import br.com.livrenz.biblioteca_api.entity.ClienteEntity;
import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperImpl implements ClienteMapper {
    @Override
    public Cliente toModel(ClienteEntity entity) {
        if (entity == null) return null;

        return Cliente.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cpf(entity.getCpf())
                .dataCriacao(entity.getDataCriacao())
                .build();
    }

    @Override
    public ClienteEntity toEntity(Cliente model) {
        if (model == null) return null;

        return ClienteEntity.builder()
                .id(model.getId())
                .nome(model.getNome())
                .cpf(model.getCpf())
                .dataCriacao(model.getDataCriacao())
                .build();
    }

    @Override
    public Cliente toModel(ClienteRequestDTO dto) {
        if (dto == null) return null;

        return Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .build();
    }

    @Override
    public ClienteResponseDTO toResponseDTO(Cliente model) {
        if (model == null) return null;

        return new ClienteResponseDTO(
                model.getId(),
                model.getNome(),
                model.getCpf(),
                model.getDataCriacao()
        );
    }
}
