package br.com.livrenz.biblioteca_api.mapper.in;

import br.com.livrenz.biblioteca_api.dto.autor.AutorRequestDTO;
import br.com.livrenz.biblioteca_api.dto.autor.AutorResponseDTO;
import br.com.livrenz.biblioteca_api.entity.AutorEntity;
import br.com.livrenz.biblioteca_api.model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toModel(AutorEntity entity);

    AutorEntity toEntity (Autor model);

    Autor toModel (AutorRequestDTO dto);

    AutorResponseDTO toResponseDTO (Autor model);
}
