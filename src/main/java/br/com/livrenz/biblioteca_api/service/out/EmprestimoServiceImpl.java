package br.com.livrenz.biblioteca_api.service.out;

import br.com.livrenz.biblioteca_api.adapter.in.ClienteAdapter;
import br.com.livrenz.biblioteca_api.adapter.in.EmprestimoAdapter;
import br.com.livrenz.biblioteca_api.adapter.in.LivroAdapter;
import br.com.livrenz.biblioteca_api.enums.StatusEmprestimo;
import br.com.livrenz.biblioteca_api.exceptions.ClienteNotFoundException;
import br.com.livrenz.biblioteca_api.exceptions.EmprestimoNotFoundException;
import br.com.livrenz.biblioteca_api.exceptions.LivroIndisponivelException;
import br.com.livrenz.biblioteca_api.exceptions.LivroNotFoundException;
import br.com.livrenz.biblioteca_api.model.Cliente;
import br.com.livrenz.biblioteca_api.model.Emprestimo;
import br.com.livrenz.biblioteca_api.model.Livro;
import br.com.livrenz.biblioteca_api.service.in.EmprestimoService;
import br.com.livrenz.biblioteca_api.service.in.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    private EmprestimoAdapter emprestimoRepository;

    @Autowired
    private ClienteAdapter clienteRepository;

    @Autowired
    private LivroAdapter livroRepository;

    @Autowired
    private LivroService livroService;

    @Override
    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
        Cliente clienteBuscado = clienteRepository.buscarClientePorCpf(emprestimo.getCliente().getCpf())
                .orElseThrow(
                        () -> new ClienteNotFoundException("Cliente não encontrado")
                );

        List<Livro> livrosBuscados = livroRepository.buscarLivroByTitulo(emprestimo.getLivro().getTitulo())
                .orElseThrow(
                        () -> new LivroNotFoundException("Livro não encontrado")
                );

        for (Livro livro : livrosBuscados) {
            if (!livro.getIdentificadorDisponivel()) {
                throw new LivroIndisponivelException("Livro indisponível para emprestimo");
            }

            Livro livrosEmprestimo = livroService.setarLivroComoIndisponivel(livro);


            emprestimo = emprestimo.toBuilder()
                    .statusEmprestimo(StatusEmprestimo.EMPRESTADO)
                    .cliente(clienteBuscado)
                    .livro(livrosEmprestimo)
                    .dataPrevistaDevolucao(LocalDate.now().plusDays(7))
                    .build();
        }


        return emprestimoRepository.salvar(emprestimo);
    }

    @Override
    public Emprestimo consultarEmprestimo(Long id) {
        return emprestimoRepository.buscarEmprestimoById(id).orElseThrow(
                () -> new EmprestimoNotFoundException("Emprestimo não encontrado!")
        );
    }

    @Override
    public Emprestimo devolverEmprestimo(Long id) {
        Emprestimo emprestimoAtivo = consultarEmprestimo(id);

        if (emprestimoAtivo.getStatusEmprestimo() == StatusEmprestimo.DEVOLVIDO ||
                emprestimoAtivo.getStatusEmprestimo() == StatusEmprestimo.ATRASADO) {
            throw new IllegalStateException("Este empréstimo já foi finalizado");
        }

        LocalDate hoje = LocalDate.now();
        LocalDate dataPrevistaDevolucao = emprestimoAtivo.getDataPrevistaDevolucao();

        StatusEmprestimo novoStatus;

        if (hoje.isAfter(dataPrevistaDevolucao)) {
            novoStatus = StatusEmprestimo.ATRASADO;
        } else {
            novoStatus = StatusEmprestimo.DEVOLVIDO;
        }

        emprestimoAtivo.getLivro().setIdentificadorDisponivel(true);
        livroService.salvar(emprestimoAtivo.getLivro());

        return emprestimoRepository.salvar(emprestimoAtivo.toBuilder()
                .statusEmprestimo(novoStatus)
                .dataDevolucao(LocalDate.now())
                .build());
    }
}
