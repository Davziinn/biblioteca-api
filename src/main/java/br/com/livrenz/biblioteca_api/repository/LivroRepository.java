package br.com.livrenz.biblioteca_api.repository;

import br.com.livrenz.biblioteca_api.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    List<LivroEntity> findByTitulo (String titulo);
}
