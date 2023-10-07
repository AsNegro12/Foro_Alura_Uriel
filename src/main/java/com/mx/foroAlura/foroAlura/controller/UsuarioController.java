package com.mx.foroAlura.foroAlura.controller;

import com.mx.foroAlura.foroAlura.topicos.DatosListarTopicos;
import com.mx.foroAlura.foroAlura.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<DatosListarUsuarios>> listarUsuarios(@PageableDefault(size=2)Pageable paginacion)
    {
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(paginacion).map(DatosListarUsuarios:: new));
    }
}
