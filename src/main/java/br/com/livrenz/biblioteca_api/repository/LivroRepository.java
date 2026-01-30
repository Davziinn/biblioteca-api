package br.com.livrenz.biblioteca_api.repository;

import br.com.livrenz.biblioteca_api.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}
