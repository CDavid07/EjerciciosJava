CREATE DATABASE apiPokemon;
USE apiPokemon;

CREATE TABLE usuario (
id  INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(255) NOT NULL
);

CREATE TABLE typePokemon (
id  INT  NOT NULL  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

CREATE TABLE pokemon (
id  INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
sprite VARCHAR(255) NULL,
type_id  INT NOT NULL,
second_type_id  INT NULL,
FOREIGN KEY (type_id) REFERENCES typePokemon(id)
);

CREATE TABLE pokemon_record (
user_id  INT  NOT NULL  ,
pokemon_id  INT  NOT NULL,
seen  INT NULL,
captured  INT NULL,
skiped  INT NULL,
FOREIGN KEY (user_id) REFERENCES usuario(id),
FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)

);

CREATE TABLE target_pokemon (
user_id  INT  NOT NULL ,
pokemon_id  INT  NOT NULL,
defense  INT NULL,
attack  INT NULL,
FOREIGN KEY (user_id) REFERENCES usuario(id),
FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)

);
CREATE TABLE captured_pokemon (
id  INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_id  INT  NOT NULL,
pokemon_id  INT  NOT NULL,
defense  INT NULL,
attack  INT NULL,
FOREIGN KEY (user_id) REFERENCES usuario(id),
FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)

);

INSERT INTO typePokemon(name) VALUES ('Acero');
INSERT INTO typePokemon(name) VALUES ('Agua');
INSERT INTO typePokemon(name) VALUES ('Bicho');
INSERT INTO typePokemon(name) VALUES ('Dragón');
INSERT INTO typePokemon(name) VALUES ('Eléctrico');
INSERT INTO typePokemon(name) VALUES ('Fantasma');
INSERT INTO typePokemon(name) VALUES ('Fuego');
INSERT INTO typePokemon(name) VALUES ('Hada');
INSERT INTO typePokemon(name) VALUES ('Hielo');
INSERT INTO typePokemon(name) VALUES ('Lucha');
INSERT INTO typePokemon(name) VALUES ('Normal');
INSERT INTO typePokemon(name) VALUES ('Planta');	
INSERT INTO typePokemon(name) VALUES ('Psíquico');
INSERT INTO typePokemon(name) VALUES ('Roca');
INSERT INTO typePokemon(name) VALUES ('Siniestro');
INSERT INTO typePokemon(name) VALUES ('Tierra');
INSERT INTO typePokemon(name) VALUES ('Veneno');
INSERT INTO typePokemon(name) VALUES ('Volador');



