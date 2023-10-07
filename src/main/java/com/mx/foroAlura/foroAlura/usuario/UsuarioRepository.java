package com.mx.foroAlura.foroAlura.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>
{
    Page<Usuarios> findByActivoTrue(Pageable paginacion);
}
