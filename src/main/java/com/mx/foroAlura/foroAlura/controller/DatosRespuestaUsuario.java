package com.mx.foroAlura.foroAlura.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRespuestaUsuario(Integer id, String nombre, String email) { }
