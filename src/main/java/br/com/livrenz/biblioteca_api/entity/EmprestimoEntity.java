package br.com.livrenz.biblioteca_api.entity;

import br.com.livrenz.biblioteca_api.enums.StatusEmprestimo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "TB_EMP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMP")
    private Long id;

    @JoinColumn(name = "ID_CLI")
    @ManyToOne()
    private ClienteEntity cliente;

    @JoinColumn(name = "ID_LIV")
    @ManyToOne()
    private LivroEntity livro;

    @Enumerated(EnumType.STRING)
    @Column(name = "ST_EMP", nullable = false)
    private StatusEmprestimo statusEmprestimo;

    @Column(name = "DT_EMP")
    @CreationTimestamp
    private LocalDate dataEmprestimo;

    @Column(name = "DT_PREV_DEV")
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "DT_DEV")
    private LocalDate dataDevolucao;

}
