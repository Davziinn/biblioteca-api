package br.com.livrenz.biblioteca_api.mapper.in;

import br.com.livrenz.biblioteca_api.dto.livro.LivroRequestDTO;
import br.com.livrenz.biblioteca_api.dto.livro.LivroResponseDTO;
import br.com.livrenz.biblioteca_api.entity.LivroEntity;
import br.com.livrenz.biblioteca_api.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivroMapper {
    Livro toModel (LivroEntity entity);

    LivroEntity toEntity (Livro model);

    @Mapping(source = "autorId", target = "autor.id")
    Livro toModel (LivroRequestDTO dto);

    LivroResponseDTO toResponseDTO (Livro model);
}
