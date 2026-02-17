package br.com.livrenz.biblioteca_api.exceptions;

public class EmprestimoNotFoundException extends RuntimeException {
    public EmprestimoNotFoundException(String message) {
        super(message);
    }
}
