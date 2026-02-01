package br.com.livrenz.biblioteca_api.exceptions;

public class AutorNotFoundException extends RuntimeException {
    public AutorNotFoundException(String message) {
        super(message);
    }
}
