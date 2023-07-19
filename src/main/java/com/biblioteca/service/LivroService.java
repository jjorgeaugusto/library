package com.biblioteca.service;

import com.biblioteca.entity.Status;
import com.biblioteca.exception.LivroJaExistenteException;
import com.biblioteca.dto.DadosAtualizacaoLivro;
import com.biblioteca.dto.DadosCadastroLivro;
import com.biblioteca.entity.Livro;
import com.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    public List<Livro> listaLivrosDisponivel() {
        return listarTodosLivros().stream().filter(l -> l.getStatus().equals(Status.DISPONIVEL))
                .collect(Collectors.toList());
    }
    public void criarNovoLivro(DadosCadastroLivro dados) {
        livroRepository.save(new Livro(dados, Status.DISPONIVEL));

    }

    public List<Livro> pesquisarLivrosPorTitulo(String nome) {
        return listarTodosLivros().stream()
                .filter(livro -> livro.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void atualizar(DadosAtualizacaoLivro dados) {
        Livro livro = livroRepository.getReferenceById(Math.toIntExact(dados.id()));
        livro.atualizarInformacoes(dados);
    }
    public void ativarLivro(Long id) {
        var livro = livroRepository.getReferenceById(Math.toIntExact(id));
        livro.ativar();
    }
    public void inativarLivro(Long id) {
        var livro = livroRepository.getReferenceById(Math.toIntExact(id));
        livro.inativo();
    }
    public boolean verificaNomeLivro(DadosCadastroLivro dados) {
        return livroRepository.existsByNome(dados.nome());
    }

    public void novoLivroVerificado(DadosCadastroLivro dados) throws LivroJaExistenteException {
        if (!verificaNomeLivro(dados)) {
            criarNovoLivro(dados);
        } else {
            throw new LivroJaExistenteException("Livro com nome " + dados.nome() + " já existe.");
        }
    }
}