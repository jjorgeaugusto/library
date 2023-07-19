package com.biblioteca.exception;

public class LivroJaExistenteException extends Exception {
    public LivroJaExistenteException(String mensagem){
        super(mensagem);
    }
}
