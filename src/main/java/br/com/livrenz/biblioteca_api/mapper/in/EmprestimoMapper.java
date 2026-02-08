package br.com.livrenz.biblioteca_api.mapper.in;


import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoRequestDTO;
import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoResponseDTO;
import br.com.livrenz.biblioteca_api.entity.EmprestimoEntity;
import br.com.livrenz.biblioteca_api.model.Emprestimo;

public interface EmprestimoMapper {
    Emprestimo toModel(EmprestimoEntity entity);

    EmprestimoEntity toEntity(Emprestimo model);

    Emprestimo toModel(EmprestimoRequestDTO dto);

    EmprestimoResponseDTO toResponseDTO(Emprestimo model);

}
