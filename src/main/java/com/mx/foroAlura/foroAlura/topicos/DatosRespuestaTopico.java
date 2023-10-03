package com.mx.foroAlura.foroAlura.topicos;

import com.mx.foroAlura.foroAlura.topicos.Estatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Integer id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Estatus estatus,
        String usuario,
        String curso
) {
}
