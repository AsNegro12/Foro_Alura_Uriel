package com.mx.foroAlura.foroAlura.topicos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosCrearTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fecha_creacion,
        Estatus estatus,
        @NotBlank
        String usuario,
        @NotBlank
        String curso
        ) {}
