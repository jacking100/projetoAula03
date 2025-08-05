create database bd_projeto_aula03;

use bd_projeto_aula03;

create table endereco(
	id                  char(36)         primary key,
	logradouro          varchar(100)     not null,
	numero              varchar(15)      not null,
	complemento         varchar(50)      not null,
	bairro              varchar(50)      not null,
	cidade              varchar(50)      not null,
	estado              varchar(25)      not null,
	cep                 varchar(10)      not null);
	
	create table funcionario(
		id               char(36)        primary key,
		nome             varchar(100)    not null,
		cpf              varchar(14)     not null unique,
		dataadmissao     date            not null,
		endereco_id      char(36),
		foreign  key(endereco_id) references endereco(id));
	