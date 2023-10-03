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

@RestController
@RequestMapping("/topicos")
public class TopicoController
{

    @Autowired
    private TopicoRespository topicoRespository;

    @PostMapping
    public void creartopico(@RequestBody @Valid DatosCrearTopico datos)
    {
        topicoRespository.save(new Topico(datos));
        System.out.println(datos);
    }
}
