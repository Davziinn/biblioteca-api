package br.com.livrenz.biblioteca_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "TB_LIV")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIV")
    private Long id;

    @Column(name = "TIT_LIV", nullable = false)
    private String titulo;

    @Column(name = "DES_LIV")
    private String descricao;

    @Column(name = "ID_DISP_LIV")
    private Boolean identificadorDisponivel;

    @CreationTimestamp
    @Column(name = "DT_CRI_LIV")
    private LocalDate dataCriacao;

    @CreationTimestamp
    @Column(name = "DT_ATU_LIV")
    private LocalDate dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "ID_AUT_LIV")
    private AutorEntity autor;
}
