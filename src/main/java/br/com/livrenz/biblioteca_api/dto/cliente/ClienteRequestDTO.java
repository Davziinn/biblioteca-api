package br.com.livrenz.biblioteca_api.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDTO {

    private String nome;
    private String cpf;
}
