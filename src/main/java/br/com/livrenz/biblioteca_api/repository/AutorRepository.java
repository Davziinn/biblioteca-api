package br.com.livrenz.biblioteca_api.repository;

import br.com.livrenz.biblioteca_api.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
}
