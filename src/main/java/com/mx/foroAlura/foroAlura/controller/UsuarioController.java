package com.mx.foroAlura.foroAlura.controller;

import com.mx.foroAlura.foroAlura.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cucrearUsuario()
    {

    }
}
