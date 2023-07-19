package com.biblioteca.dto;

import com.biblioteca.entity.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(@NotNull Long id, String nome, String autor, Status status) {

}
