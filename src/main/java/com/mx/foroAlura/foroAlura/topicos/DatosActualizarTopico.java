package com.mx.foroAlura.foroAlura.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Integer id, String titulo, String mensaje, Estatus estatus) {
}
