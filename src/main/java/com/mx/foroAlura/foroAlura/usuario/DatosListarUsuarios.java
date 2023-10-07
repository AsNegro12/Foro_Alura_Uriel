package com.mx.foroAlura.foroAlura.usuario;

public record DatosListarUsuarios(Integer id, String nombre, String email)
{

    public DatosListarUsuarios(Usuarios usuarios)
    {
        this(usuarios.getId(), usuarios.getNombre(), usuarios.getEmail());
    }
}
