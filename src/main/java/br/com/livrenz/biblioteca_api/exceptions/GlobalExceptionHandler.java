package br.com.livrenz.biblioteca_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Object> buildResponse (HttpStatus status, String mensagem) {

        Map<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", status);
        body.put("error", status.getReasonPhrase());
        body.put("mensagem", mensagem);

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(ClienteJaExisteException.class)
    public ResponseEntity<Object> handleClienteJaExisteException (ClienteJaExisteException ex) {
        return buildResponse(HttpStatus.FOUND, ex.getMessage());
    }
}
