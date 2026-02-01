package br.com.livrenz.biblioteca_api.exceptions;

public class ClienteJaExisteException extends RuntimeException {
    public ClienteJaExisteException(String message) {
        super(message);
    }
}
