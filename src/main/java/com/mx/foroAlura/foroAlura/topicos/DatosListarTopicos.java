package com.mx.foroAlura.foroAlura.topicos;

import java.time.LocalDateTime;

public record DatosListarTopicos(Integer id, String titulo, String mensaje, LocalDateTime fecha_creacion, String estatus, String usuario, String curso)
{
    public DatosListarTopicos(Topico topico)
    {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getEstatus().toString(), topico.getUsuario(), topico.getCurso());
    }
}
