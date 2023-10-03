CREATE TABLE topicos(
    id BIGINT NOT NULL auto_increment,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fecha_creacion DATE NOT NULL,
    estatus VARCHAR(25) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL,

    primary key(id)
);