create table pessoa(
    id varchar(255) not null  primary key,
    nome varchar(50) not null,
    sexo char,
    cpf varchar(12),
    telefone varchar(20),
    email varchar(20),
    profissao varchar(50)
);