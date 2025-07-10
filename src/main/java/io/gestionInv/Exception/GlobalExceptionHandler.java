package io.gestionInv.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RessourceIntrouvableException.class)
    public ResponseEntity<Object> handleRessourceIntrouvable(RessourceIntrouvableException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

   /* @ExceptionHandler(RessourceIntrouvableException.class)
    public ResponseEntity<String> handleNotFound(RessourceIntrouvableException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }*/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenerale(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur interne : " + ex.getMessage());
    }

    private ResponseEntity<Object> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}
