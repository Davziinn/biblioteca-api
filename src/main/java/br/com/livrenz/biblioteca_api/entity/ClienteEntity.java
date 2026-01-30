package br.com.livrenz.biblioteca_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CLI")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLI")
    private Long id;

    @Column(name = "NM_CLI", nullable = false)
    private String nome;

    @Column(name = "CPF_CLI", nullable = false, unique = true)
    private String cpf;

    @CreationTimestamp
    @Column(name = "DT_CRI_CLI")
    private LocalDate dataCriacao;
}
