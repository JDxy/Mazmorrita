DROP DATABASE ProyectoMazmorrita;
CREATE DATABASE ProyectoMazmorrita;

USE ProyectoMazmorrita;

CREATE TABLE Usuarios (
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(20) NOT NULL,
    Contraseña VARCHAR(20) NOT NULL
);

CREATE TABLE Pisos (
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ImagenPiso VARCHAR(50) NULL,
    Numero INT NOT NULL,
    NumeroEnemigos INT NOT NULL
);

CREATE TABLE Enemigos(
    Nombre VARCHAR(50) PRIMARY KEY,
    IdPiso INT NOT NULL,
    Avatar VARCHAR(50) NULL,
    Vida INT NOT NULL,
    Fuerza INT NOT NULL,
    Defensa INT NOT NULL,
    Jefe INTEGER NOT NULL,
    Botin VARCHAR(28),
    FOREIGN KEY (IdPiso) REFERENCES Pisos(Id));

CREATE TABLE Personajes(
    Nombre VARCHAR(50) NOT NULL,
    IdUsuario INT NOT NULL,
    IdPiso INT NOT NULL,
    Avatar VARCHAR(200) NOT NULL,
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
    Nombre VARCHAR(50) NOT NULL,
    IdUsuario INT NOT NULL,
    NombrePersonaje VARCHAR(50) NOT NULL,
    Fuerza INT DEFAULT 0,
    Defensa INT DEFAULT 0,
    Vida INT DEFAULT 0,
    Magia INT DEFAULT 0,
    Mana INT DEFAULT 0,
    PRIMARY KEY(Nombre, IdUsuario, NombrePersonaje),
    FOREIGN KEY(IdUsuario, NombrePersonaje) REFERENCES Personajes(IdUsuario, Nombre));

CREATE TABLE Ataques(
	Nombre VARCHAR(50) PRIMARY KEY,
    Potencia INT,
	Tipo ENUM("Magico", "Fisico"));

CREATE TABLE Ataque_enemigo(
    NombreAtaque VARCHAR(50) NOT NULL,
    NombreEnemigo VARCHAR(50) NOT NULL,
    Potencia INT DEFAULT 0,
    PRIMARY KEY(NombreAtaque, NombreEnemigo),
    FOREIGN KEY(NombreEnemigo) REFERENCES Enemigos(Nombre));

CREATE TABLE Ataque_personaje(
    NombreAtaque VARCHAR(50) NOT NULL,
    IdUsuario INT NOT NULL,
    NombrePersonaje VARCHAR(50) NOT NULL,
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

-- Ataques Mago
INSERT INTO Ataques VALUES("Golpe de baston", 20, "Fisico");
INSERT INTO Ataques VALUES("Enciclopediaso", 15, "Fisico");
INSERT INTO Ataques VALUES("Bola de fuego", 45, "Magico");
INSERT INTO Ataques VALUES("Invocar Trueno", 65, "Magico");
INSERT INTO Ataques VALUES("Corte arcano", 80, "Magico");

-- Ataques barbaro
INSERT INTO Ataques VALUES("QUE TE MATOOOOOOOOOO!!!!", 25, "Fisico");
INSERT INTO Ataques VALUES("Golpe de Furia", 15, "Fisico");
INSERT INTO Ataques VALUES("Testarazo", 20, "Fisico");
INSERT INTO Ataques VALUES("Mini Temblor", 35, "Magico");
INSERT INTO Ataques VALUES("Carga Ignea", 40, "Magico");

-- Ataques Picaro
INSERT INTO Ataques VALUES("Disparo normal", 15, "Fisico");
INSERT INTO Ataques VALUES("Disparo preciso", 25, "Fisico");
INSERT INTO Ataques VALUES("Golpe con la flecha", 10, "Fisico");
INSERT INTO Ataques VALUES("Flecha espiritual", 34, "Magico");
INSERT INTO Ataques VALUES("Ira de Armonia", 90, "Magico");

INSERT INTO Pisos(Numero, NumeroEnemigos) VALUES(1, 3);
INSERT INTO Pisos(Numero, NumeroEnemigos) VALUES(2, 5);


INSERT INTO Enemigos VALUES("Esqueleto", 1, null, 50, 12, 5, 0, 10);
INSERT INTO Enemigos VALUES("Slime", 1, null, 10, 5, 25, 0, 8);
INSERT INTO Enemigos VALUES("Zombie", 1, null, 25, 24, 5, 0, 20);
INSERT INTO Enemigos VALUES("Imp", 1, null, 14, 20, 20, 0, 50);

INSERT INTO Enemigos VALUES("Titan: Ecanthy", 1, null, 125, 35, 25, 1, 200);
INSERT INTO Enemigos VALUES("Dragon del lamento: Cocoona", 1, null, 100, 35, 40, 1, 200);

INSERT INTO Enemigos VALUES("Bruja", 2, null, 50, 45, 15, 0, 50);
INSERT INTO Enemigos VALUES("Demonio", 2, null, 75, 15, 50, 0, 55);
INSERT INTO Enemigos VALUES("Perro Infectado", 2, null, 55, 33, 24, 0, 60);
INSERT INTO Enemigos VALUES("Vampiro", 2, null, 45, 30, 30, 0, 100);

INSERT INTO Enemigos VALUES("El enigmatico: XI", 2, null, 280, 15, 80, 1, 500);
INSERT INTO Enemigos VALUES("Emperatriz Arlequin: Zanoria", 2, null, 225, 70, 35, 1, 500);


-- Ataques Cocoona
INSERT INTO Ataques(Nombre, Potencia) VALUES("Lamento de encierro", 120);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Golpe Fantasma", 50);
INSERT INTO Ataque_enemigo VALUES("Lamento de encierro", "Dragon del lamento: Cocoona",120);
INSERT INTO Ataque_enemigo VALUES("Golpe Fantasma", "Dragon del lamento: Cocoona",200);

-- Ataques Ecanthy
INSERT INTO Ataques(Nombre, Potencia) VALUES("Golpe de los 50 Brazos", 120);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Retumbo de tierra", 50);
INSERT INTO Ataque_enemigo VALUES("Golpe de los 50 Brazos", "Titan: Ecanthy",120);
INSERT INTO Ataque_enemigo VALUES("Retumbo de tierra", "Titan: Ecanthy",200);

-- Ataques XI
INSERT INTO Ataques(Nombre, Potencia) VALUES("Cometa Incoloro", 240);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Distorcion existencial", 45);
INSERT INTO Ataque_enemigo VALUES("Cometa Incoloro", "El enigmatico: XI",60);
INSERT INTO Ataque_enemigo VALUES("Distorcion existencial", "El enigmatico: XI",40);

-- Ataques Zanoria
INSERT INTO Ataques(Nombre, Potencia) VALUES("TODO EL MUNDO A BAILAR!", 120);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Atraccion de Circo", 60);
INSERT INTO Ataque_enemigo VALUES("TODO EL MUNDO A BAILAR!", "Emperatriz Arlequin: Zanoria",60);
INSERT INTO Ataque_enemigo VALUES("Atraccion de Circo", "Emperatriz Arlequin: Zanoria",40);

-- Ataques Enemigos
INSERT INTO Ataques(Nombre, Potencia) VALUES("Golpe", 20);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Estocada", 25);
INSERT INTO Ataques VALUES("Felonia Simpatica", 20, "Magico");
INSERT INTO Ataques VALUES("Invocar Nombre", 25, "Magico");
INSERT INTO Ataques VALUES("Ataque emocional", 35, "Magico");

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Esqueleto",20);
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Esqueleto",20);

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Slime",20);
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Slime",20);

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Zombie",20);
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Zombie",20);

INSERT INTO Ataque_Enemigo VALUES("Felonia Simpatica", "Imp",20);
INSERT INTO Ataque_Enemigo VALUES("Invocar Nombre", "Imp",20);

INSERT INTO Ataque_Enemigo VALUES("Felonia Simpatica", "Bruja",30);
INSERT INTO Ataque_Enemigo VALUES("Invocar Nombre", "Bruja",30);
INSERT INTO ataque_enemigo VALUES("Ataque emocional", "Bruja",30);

INSERT INTO Ataque_Enemigo VALUES("Felonia Simpatica", "Vampiro",30);
INSERT INTO Ataque_Enemigo VALUES("Invocar Nombre", "Vampiro",30);
INSERT INTO ataque_enemigo VALUES("Ataque emocional", "Vampiro",30);

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Demonio",40);
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Demonio",40);
INSERT INTO ataque_enemigo VALUES("Ataque emocional", "Demonio",40);

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Perro Infectado",30);
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Perro Infectado",30);