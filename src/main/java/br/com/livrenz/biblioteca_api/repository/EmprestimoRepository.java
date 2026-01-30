package br.com.livrenz.biblioteca_api.repository;

import br.com.livrenz.biblioteca_api.entity.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
}
