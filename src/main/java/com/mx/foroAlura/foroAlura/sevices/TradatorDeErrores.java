package com.mx.foroAlura.foroAlura.sevices;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class TradatorDeErrores
{
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Validaciones.class)
    public ResponseEntity<Object> YaExisteTopico(Validaciones ex) {

        DatosErrorValidacion errorResponse = new DatosErrorValidacion(HttpStatus.CONFLICT.value(), "El tópico ya existe");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    private record DatosErrorValidacion(Object campo, String error)
    {
        public DatosErrorValidacion(FieldError error)
        {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
