package br.com.livrenz.biblioteca_api.controller.in;

import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoRequestDTO;
import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface EmprestimoController {

    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> criarEmprestimo(@RequestBody EmprestimoRequestDTO emprestimo);

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> consultarEmprestimo(@PathVariable Long id);

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> devolverEmprestimo(@PathVariable Long id);
}
