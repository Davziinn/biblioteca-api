package br.com.livrenz.biblioteca_api.controller.out;

import br.com.livrenz.biblioteca_api.controller.in.EmprestimoController;
import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoRequestDTO;
import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoResponseDTO;
import br.com.livrenz.biblioteca_api.mapper.in.EmprestimoMapper;
import br.com.livrenz.biblioteca_api.service.in.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoRestController implements EmprestimoController {

    @Autowired
    private EmprestimoService  emprestimoService;

    @Autowired
    private EmprestimoMapper mapper;

    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> criarEmprestimo(@RequestBody EmprestimoRequestDTO emprestimo) {
        EmprestimoResponseDTO emprestimoDTO = mapper.toResponseDTO(emprestimoService.salvarEmprestimo(mapper.toModel(emprestimo)));

        return ResponseEntity.ok().body(emprestimoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> consultarEmprestimo (@PathVariable Long id) {
        EmprestimoResponseDTO emprestimoResponseDTO = mapper.toResponseDTO(emprestimoService.consultarEmprestimo(id));

        return ResponseEntity.ok().body(emprestimoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> devolverEmprestimo(@PathVariable Long id) {
        EmprestimoResponseDTO emprestimoResponseDTO = mapper.toResponseDTO(emprestimoService.devolverEmprestimo(id));

        return ResponseEntity.ok().body(emprestimoResponseDTO);
    }
}
