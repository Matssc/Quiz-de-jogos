CREATE DATABASE quizdb;
USE quizdb;

CREATE TABLE perguntas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(50),
    enunciado TEXT,
    alternativaA VARCHAR(255),
    alternativaB VARCHAR(255),
    alternativaC VARCHAR(255),
    alternativaD VARCHAR(255),
    correta CHAR(1)
);
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    pontuacao INT DEFAULT 0
);
