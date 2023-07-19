package com.biblioteca.controller;

import com.biblioteca.dto.DadosAtualizacaoLivro;
import com.biblioteca.dto.DadosCadastroLivro;
import com.biblioteca.exception.LivroJaExistenteException;
import com.biblioteca.service.LivroService;
import com.biblioteca.entity.Livro;
import com.biblioteca.exception.LivroEmprestadoException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroLivro dados) throws LivroJaExistenteException {
        livroService.novoLivroVerificado(dados);
    }
    @GetMapping
    public List<Livro> buscar(){
        return livroService.listarTodosLivros().stream().toList();
    }

    @GetMapping("/disponivel")
    public List<Livro> listaLivrosDisponiveis(){
        return livroService.listaLivrosDisponivel();
    }

    @GetMapping("/search")
    public List<Livro> pesquisarLivrosPorTitulo(@RequestParam("nome") String termoPesquisa) {
        return livroService.pesquisarLivrosPorTitulo(termoPesquisa);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoLivro dados){
        livroService.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        livroService.inativarLivro(id);
    }

    @PutMapping("/emprestar")
    @Transactional
    public void emprestarLivro(@RequestBody @Valid DadosAtualizacaoLivro dados) {
        livroService.inativarLivro(dados.id());
    }
    @PutMapping("/devolver")
    @Transactional
    public void devolverLivro(@RequestBody @Valid DadosAtualizacaoLivro dados){
        livroService.ativarLivro(dados.id());
    }
}