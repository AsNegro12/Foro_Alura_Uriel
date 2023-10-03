package com.mx.foroAlura.foroAlura.controller;

import com.mx.foroAlura.foroAlura.sevices.Validaciones;
import com.mx.foroAlura.foroAlura.topicos.*;
import jakarta.transaction.Transactional;
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
@RequestMapping("/topicos")
public class TopicoController
{

    @Autowired
    private TopicoRespository topicoRespository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> creartopico(@RequestBody @Valid DatosCrearTopico datos, UriComponentsBuilder uriComponentsBuilder)
    {
        if(topicoRespository.findByTitulo(datos.titulo()) != null)
        {
            throw new Validaciones("El titulo ya existe");
        }
        if(topicoRespository.findByMensaje(datos.mensaje()) != null)
        {
            throw new Validaciones("El mensaje ya existe");
        }

        Topico topico = topicoRespository.save(new Topico(datos));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getEstatus(),
                topico.getUsuario(), topico.getCurso()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public Page<DatosListarTopicos> listarTopicos(@PageableDefault(size=5) Pageable paginacion)
    {
        return topicoRespository.findByActivoTrue(paginacion).map(DatosListarTopicos:: new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> ActualizarTopico(@RequestBody @Valid DatosActualizarTopico datos, UriComponentsBuilder uriComponentsBuilder)
    {
        Topico topico =  topicoRespository.getReferenceById(datos.id());
        topico.actualizar(datos);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getEstatus(),
                topico.getUsuario(), topico.getCurso()
        );
        URI url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> eliminarTopico(@PathVariable Integer id)
    {
        Topico topico = topicoRespository.getReferenceById(id);
        topico.desactivarTopico();

        return ResponseEntity.noContent().build();
    }

@GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retirnarTopico(@PathVariable Integer id)
    {
        Topico topico = topicoRespository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getEstatus(),
                topico.getUsuario(), topico.getCurso()
        );

        return  ResponseEntity.ok(datosTopico);
    }
}
