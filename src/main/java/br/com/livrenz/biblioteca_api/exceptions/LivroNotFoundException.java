package br.com.livrenz.biblioteca_api.exceptions;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(String message) {
        super(message);
    }
}
