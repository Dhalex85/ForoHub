create table topicos (
    id bigint auto_increment primary key,
    titulo varchar(100) not null,
    autor varchar(100) not null,
    mensaje varchar(500) not null,
    curso varchar(100) not null,
    fecha_creacion datetime not null,
    respuestas int not null,
    status varchar(10) not null
);