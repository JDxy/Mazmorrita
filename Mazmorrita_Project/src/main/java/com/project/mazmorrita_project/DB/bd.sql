DROP DATABASE ProyectoMazmorrita;
CREATE DATABASE ProyectoMazmorrita;

USE ProyectoMazmorrita;

CREATE TABLE Usuarios (
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(14) NOT NULL,
    Contraseña VARCHAR(14) NOT NULL
);

CREATE TABLE Pisos (
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ImagenPiso VARCHAR(50) NOT NULL,
    Numero INT NOT NULL,
    NumeroEnemigos INT NOT NULL
);

CREATE TABLE Enemigos(
    Nombre VARCHAR(14) PRIMARY KEY,
    IdPiso INT NOT NULL,
    Avatar VARCHAR(50) NOT NULL,
    Vida INT NOT NULL,
    Fuerza INT NOT NULL,
    Defensa INT NOT NULL,
    Jefe INTEGER NOT NULL,
    Botin VARCHAR(28),
    FOREIGN KEY (IdPiso) REFERENCES Pisos(Id));

CREATE TABLE Personajes(
    Nombre VARCHAR(14) NOT NULL,
    IdUsuario INT NOT NULL,
    IdPiso INT NOT NULL,
    Avatar VARCHAR(100) NOT NULL,
    Vida INT NOT NULL,
    Fuerza INT NOT NULL,
    Defensa INT NOT NULL,
    Magia INT NOT NULL,
    Mana INT NOT NULL,
    Experiencia INT DEFAULT 0,
    Clase TEXT NOT NULL CHECK(Clase IN ('Mago', 'Barbaro', 'Picaro')),
    PRIMARY KEY(Nombre, IdUsuario),
    FOREIGN KEY(IdPiso) REFERENCES Pisos(Id),
    FOREIGN KEY(IdUsuario) REFERENCES Usuarios(Id));

CREATE TABLE Armas(
    Nombre VARCHAR(14) NOT NULL,
    IdUsuario INT NOT NULL,
    NombrePersonaje VARCHAR(14) NOT NULL,
    Fuerza INT DEFAULT 0,
    Defensa INT DEFAULT 0,
    Vida INT DEFAULT 0,
    Magia INT DEFAULT 0,
    Mana INT DEFAULT 0,
    PRIMARY KEY(Nombre, IdUsuario, NombrePersonaje),
    FOREIGN KEY(IdUsuario, NombrePersonaje) REFERENCES Personajes(IdUsuario, Nombre));

CREATE TABLE Ataque_enemigo(
    NombreAtaque VARCHAR(14) NOT NULL,
    NombreEnemigo VARCHAR(14) NOT NULL,
    Potencia INT DEFAULT 0,
    PRIMARY KEY(NombreAtaque, NombreEnemigo),
    FOREIGN KEY(NombreEnemigo) REFERENCES Enemigos(Nombre));

CREATE TABLE Ataque_personaje(
    NombreAtaque VARCHAR(14) NOT NULL,
    IdUsuario INT NOT NULL,
    NombrePersonaje VARCHAR(14) NOT NULL,
    Potencia INT DEFAULT 0,
    Tipo TEXT NOT NULL CHECK(Tipo IN ('Magico', 'Fisico')),
    PRIMARY KEY(NombreAtaque, IdUsuario, NombrePersonaje),
    FOREIGN KEY(IdUsuario, NombrePersonaje) REFERENCES Personajes(IdUsuario, Nombre));

DELIMITER //

CREATE TRIGGER Armas_B_I BEFORE INSERT ON Armas
FOR EACH ROW
BEGIN
    SET NEW.Fuerza = IFNULL(NEW.Fuerza, 0);
    SET NEW.Defensa = IFNULL(NEW.Defensa, 0);
    SET NEW.Vida = IFNULL(NEW.Vida, 0);
    SET NEW.Magia = IFNULL(NEW.Magia, 0);
    SET NEW.Mana = IFNULL(NEW.Mana, 0);
END //

CREATE TRIGGER AtaqueEnemigo_B_I BEFORE INSERT ON Ataque_enemigo
FOR EACH ROW
BEGIN
    SET NEW.Potencia = IFNULL(NEW.Potencia, 0);
END //

CREATE TRIGGER AtaquePersonaje_B_I BEFORE INSERT ON Ataque_personaje
FOR EACH ROW
BEGIN
    SET NEW.Potencia = IFNULL(NEW.Potencia, 0);
END //

DELIMITER ;