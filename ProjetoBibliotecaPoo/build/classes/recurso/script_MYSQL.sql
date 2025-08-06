drop database if exists library;
create database library;
use library;

create table book(
codigo int auto_increment primary key,
title varchar(50),
author varchar(50),
genre VARCHAR(30)
);


use library;

INSERT INTO book (title, author, genre) 
VALUES ('O iluminado', 'Stephen King', 'Terror');
INSERT INTO book (title, author, genre) 
VALUES ('Garota Exemplas', 'Gillian Flyn', 'Suspense');
INSERT INTO book (title, author, genre) 
VALUES ('Orgulho e Preconceito ', 'Jane Austen', 'Clássico');
INSERT INTO book (title, author, genre) 
VALUES ('Probleba dos Três Corpos', 'Liu Cixin', 'Ficção Científica');
