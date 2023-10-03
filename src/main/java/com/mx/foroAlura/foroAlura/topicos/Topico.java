package com.mx.foroAlura.foroAlura.topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;

    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    private String usuario;
    private String curso;
    private Boolean activo;


    public Topico(DatosCrearTopico datos)
    {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha_creacion = LocalDateTime.now();
        this.estatus = Estatus.NO_RESPONDIDO;
        this.usuario = datos.usuario();
        this.curso = datos.curso();
        this.activo = true;
    }

    public void actualizar(DatosActualizarTopico datos)
    {
        if(datos.titulo() != null)
        {
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null)
        {
            this.mensaje = datos.mensaje();
        }
        if(datos.estatus() != null)
        {
            this.estatus = datos.estatus();
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}
