package com.mx.foroAlura.foroAlura.controller;

import com.mx.foroAlura.foroAlura.topicos.DatosRespuestaTopico;
import com.mx.foroAlura.foroAlura.usuario.UsuarioRepository;
import com.mx.foroAlura.foroAlura.usuario.Usuarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> crearUsuario(@RequestBody @Valid DatosRegistrarUsuario datos, UriComponentsBuilder uriComponentsBuilder)
    {
        Usuarios usuarios = usuarioRepository.save(new Usuarios(datos));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
                usuarios.getId(), usuarios.getNombre(), usuarios.getEmail()
        );

        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuarios.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }
}
