package br.com.livrenz.biblioteca_api.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDTO {

    private String nome;

    @Length(message = "O campo [CPF] deve conter até 11 números")
    private String cpf;
}
