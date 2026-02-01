package br.com.livrenz.biblioteca_api.dto.cliente;

import java.time.LocalDate;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String cpf,
        LocalDate dataCriacao
) {
}
