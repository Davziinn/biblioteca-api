package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoRequestDTO;
import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmprestimoController {

    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> criarEmprestimo(@RequestBody EmprestimoRequestDTO emprestimo);

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> consultarEmprestimo (@PathVariable Long id);
}
