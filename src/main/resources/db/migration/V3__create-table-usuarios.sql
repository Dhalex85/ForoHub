create table usuarios (
    id bigint not null auto_increment primary key,
    user varchar(50) not null,
    pass varchar(100) not null
);