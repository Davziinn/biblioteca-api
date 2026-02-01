package br.com.livrenz.biblioteca_api.repository;

import br.com.livrenz.biblioteca_api.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByCpf(String cpf);
}
