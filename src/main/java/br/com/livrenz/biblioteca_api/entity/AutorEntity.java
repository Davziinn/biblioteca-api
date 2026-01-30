package br.com.livrenz.biblioteca_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_AUT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUT")
    private Long id;

    @Column(name = "NM_AUT", nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private List<LivroEntity> livros;

    @CreationTimestamp
    @Column(name = "DT_CRI_AUT")
    private LocalDate dataCriacao;
}
