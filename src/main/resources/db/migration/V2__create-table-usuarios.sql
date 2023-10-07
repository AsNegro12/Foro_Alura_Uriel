CREATE TABLE usuarios(
    id BIGINT NOT NULL auto_increment,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(25) NOT NULL,
    activo BOOLEAN,

    primary key(id)
);