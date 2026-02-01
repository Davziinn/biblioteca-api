package br.com.livrenz.biblioteca_api.dto.cliente;

import java.time.LocalDateTime;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String cpf,
        LocalDateTime dataCriacao
) {
}
