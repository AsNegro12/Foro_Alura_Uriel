package com.mx.foroAlura.foroAlura.controller;

import com.mx.foroAlura.foroAlura.topicos.DatosCrearTopico;
import com.mx.foroAlura.foroAlura.topicos.Topico;
import com.mx.foroAlura.foroAlura.topicos.TopicoRespository;
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
@RequestMapping("/topicos")
public class TopicoController
{

    @Autowired
    private TopicoRespository topicoRespository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> creartopico(@RequestBody @Valid DatosCrearTopico datos, UriComponentsBuilder uriComponentsBuilder)
    {
        Topico topico = topicoRespository.save(new Topico(datos));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getEstatus(),
                topico.getUsuario(), topico.getCurso()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}