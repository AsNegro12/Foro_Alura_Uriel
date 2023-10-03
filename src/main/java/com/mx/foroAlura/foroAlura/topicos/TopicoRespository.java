package com.mx.foroAlura.foroAlura.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRespository extends JpaRepository<Topico, Integer>
{
    Page<Topico> findByActivoTrue(Pageable paginacion);

    Topico findByTitulo(String duplicado);

    Topico findByMensaje(String mensaje);
}
