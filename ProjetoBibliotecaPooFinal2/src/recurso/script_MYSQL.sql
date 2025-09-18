drop database if exists library;
create database library;
use library;

create table book(
codigo int auto_increment primary key,
title varchar(50),
author varchar(50),
ano int,
genre VARCHAR(30),
editora VARCHAR(50),
pagtotais int,
paglidas int,
 usuario VARCHAR(50)
);

CREATE TABLE usuario (
    userid INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    userpass VARCHAR(50) NOT NULL
);






//page2
use library;



INSERT INTO book (title, author, ano, genre, editora, pagtotais, paglidas, usuario) 
VALUES ('Lovecraft', 'Lovecraft', 2018, 'Terror', 'Darkside Books', 100, 100, 'teste');

INSERT INTO book (title, author, ano, genre, editora, pagtotais, paglidas, usuario) 
VALUES ('Codigo da Vinci', 'Dan Brown', 2006, 'Suspense', 'Sextante', 1000, 50, 'teste2');

INSERT INTO book (title, author, ano, genre, editora, pagtotais, paglidas, usuario) 
VALUES ('Divina Comedia', 'Dante Alighieri', 2011, 'Clássico', 'Principis', 2000, 5, 'teste');

INSERT INTO book (title, author, ano, genre, editora, pagtotais, paglidas, usuario) 
VALUES ('Guerra Mundial Z', 'Max Brooks', 2006, 'Ficção Científica', 'Rocco', 100, 100, 'teste2');

INSERT INTO usuario (username, userpass) VALUES('teste', 'teste');
INSERT INTO usuario (username, userpass) VALUES('teste2', '123');
INSERT INTO usuario (username, userpass) VALUES('admin', 'admin');