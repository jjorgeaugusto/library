package com.biblioteca.dto;
import com.biblioteca.entity.Status;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastroLivro(@NotBlank String nome, @NotBlank String autor, Status status, String descricao) {

    public DadosCadastroLivro(String nome, String autor, Status status, String descricao) {
        this.status = Status.DISPONIVEL;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
    }
}
