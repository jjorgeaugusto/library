package com.biblioteca.dto;

import com.biblioteca.entity.Status;

public record DadosListagemLivro(Long id, String nome, String autor, Status status, String descricao) {

    public void DadosListagemLivro(String nome){
    }
}
