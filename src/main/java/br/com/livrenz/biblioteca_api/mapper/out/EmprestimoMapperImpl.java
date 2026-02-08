package br.com.livrenz.biblioteca_api.mapper.out;

import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoRequestDTO;
import br.com.livrenz.biblioteca_api.dto.emprestimo.EmprestimoResponseDTO;
import br.com.livrenz.biblioteca_api.entity.EmprestimoEntity;
import br.com.livrenz.biblioteca_api.mapper.in.ClienteMapper;
import br.com.livrenz.biblioteca_api.mapper.in.EmprestimoMapper;
import br.com.livrenz.biblioteca_api.mapper.in.LivroMapper;
import br.com.livrenz.biblioteca_api.model.Cliente;
import br.com.livrenz.biblioteca_api.model.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapperImpl implements EmprestimoMapper {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private LivroMapper livroMapper;

    @Override
    public Emprestimo toModel(EmprestimoEntity entity) {
        if (entity == null) return null;

        return Emprestimo.builder()
                .id(entity.getId())
                .cliente(clienteMapper.toModel(entity.getCliente()))
                .livro(livroMapper.toModel(entity.getLivro()))
                .statusEmprestimo(entity.getStatusEmprestimo())
                .dataEmprestimo(entity.getDataEmprestimo())
                .dataDevolucao(entity.getDataDevolucao())
                .build();
    }

    @Override
    public EmprestimoEntity toEntity(Emprestimo model) {
        if(model == null) return null;

        return EmprestimoEntity.builder()
                .id(model.getId())
                .cliente(clienteMapper.toEntity(model.getCliente()))
                .livro(livroMapper.toEntity(model.getLivro()))
                .statusEmprestimo(model.getStatusEmprestimo())
                .dataEmprestimo(model.getDataEmprestimo())
                .dataDevolucao(model.getDataDevolucao())
                .build();
    }

    @Override
    public Emprestimo toModel(EmprestimoRequestDTO dto) {
        if(dto == null) return null;

        return Emprestimo.builder()
                .statusEmprestimo(dto.getStatusEmprestimo())
                .build();
    }

    @Override
    public EmprestimoResponseDTO toResponseDTO(Emprestimo model) {
        if(model == null) return null;

        return new EmprestimoResponseDTO(
                model.getId(),
                clienteMapper.toResponseDTO(model.getCliente()),
                livroMapper.toResponseDTO(model.getLivro()),
                model.getStatusEmprestimo(),
                model.getDataEmprestimo(),
                model.getDataDevolucao()
        );
    }
}
