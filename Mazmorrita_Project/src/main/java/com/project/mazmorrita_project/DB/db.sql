DROP DATABASE ProyectoMazmorrita;
CREATE DATABASE ProyectoMazmorrita;

USE ProyectoMazmorrita;

CREATE TABLE Usuarios (
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(20) NOT NULL,
    Contraseña VARCHAR(20) NOT NULL
);

CREATE TABLE Pisos (
    Id INT PRIMARY KEY AUTO_INCREMENT,
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
    Jefe TINYINT NOT NULL,
    Botin INT,
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
    Clase ENUM( "Mago", "Barbaro", "Picaro") NOT NULL,
    PRIMARY KEY(Nombre, IdUsuario),
    FOREIGN KEY(IdPiso) REFERENCES Pisos(Id),
    FOREIGN KEY(IdUsuario) REFERENCES Usuarios(Id));

CREATE TABLE Armas(
    Nombre VARCHAR(50) NOT NULL,
    NombrePersonaje VARCHAR(50) NOT NULL,
    Fuerza INT,
    Defensa INT,
    Vida INT,
    Magia INT,
    Mana INT,
    PRIMARY KEY(Nombre, NombrePersonaje),
    FOREIGN KEY(NombrePersonaje) REFERENCES Personajes(Nombre));

CREATE TABLE Ataques(
	Nombre VARCHAR(50) PRIMARY KEY,
    Potencia INT,
	Tipo ENUM("Magico", "Fisico"));

CREATE TABLE Ataque_enemigo(
	NombreAtaque VARCHAR(50) NOT NULL,
    NombreEnemigo VARCHAR(50) NOT NULL,
    PRIMARY KEY(NombreAtaque, NombreEnemigo),
    FOREIGN KEY(NombreEnemigo) REFERENCES Enemigos(Nombre),
    FOREIGN KEY(NombreAtaque) REFERENCES Ataques(Nombre));

CREATE TABLE Ataque_personaje(
	NombreAtaque VARCHAR(50) NOT NULL,
    NombrePersonaje VARCHAR(14) NOT NULL,
	PRIMARY KEY(NombreAtaque, NombrePersonaje),
    FOREIGN KEY(NombrePersonaje) REFERENCES Personajes(Nombre),
    FOREIGN KEY(NombreAtaque) REFERENCES Ataques(Nombre));

DELIMITER //

CREATE TRIGGER Armas_B_I BEFORE INSERT ON Armas
	FOR EACH ROW
    BEGIN
		IF (NEW.Fuerza IS NULL) THEN SET NEW.Fuerza = 0; END IF;
        IF (NEW.Defensa IS NULL) THEN SET NEW.Defensa = 0; END IF;
        IF (NEW.Vida IS NULL) THEN SET NEW.Vida = 0; END IF;
        IF (NEW.Magia IS NULL) THEN SET NEW.Magia = 0; END IF;
        IF (NEW.Mana IS NULL) THEN SET NEW.Mana = 0; END IF;
	END;
    //
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
INSERT INTO Ataque_enemigo VALUES("Lamento de encierro", "Dragon del lamento: Cocoona");
INSERT INTO Ataque_enemigo VALUES("Golpe Fantasma", "Dragon del lamento: Cocoona");

-- Ataques Ecanthy
INSERT INTO Ataques(Nombre, Potencia) VALUES("Golpe de los 50 Brazos", 120);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Retumbo de tierra", 50);
INSERT INTO Ataque_enemigo VALUES("Golpe de los 50 Brazos", "Titan: Ecanthy");
INSERT INTO Ataque_enemigo VALUES("Retumbo de tierra", "Titan: Ecanthy");

-- Ataques XI
INSERT INTO Ataques(Nombre, Potencia) VALUES("Cometa Incoloro", 240);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Distorcion existencial", 45);
INSERT INTO Ataque_enemigo VALUES("Cometa Incoloro", "El enigmatico: XI");
INSERT INTO Ataque_enemigo VALUES("Distorcion existencial", "El enigmatico: XI");

-- Ataques Zanoria
INSERT INTO Ataques(Nombre, Potencia) VALUES("TODO EL MUNDO A BAILAR!", 120);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Atraccion de Circo", 60);
INSERT INTO Ataque_enemigo VALUES("TODO EL MUNDO A BAILAR!", "Emperatriz Arlequin: Zanoria");
INSERT INTO Ataque_enemigo VALUES("Atraccion de Circo", "Emperatriz Arlequin: Zanoria");

-- Ataques Enemigos
INSERT INTO Ataques(Nombre, Potencia) VALUES("Golpe", 20);
INSERT INTO Ataques(Nombre, Potencia) VALUES("Estocada", 25);
INSERT INTO Ataques VALUES("Felonia Simpatica", 20, "Magico");
INSERT INTO Ataques VALUES("Invocar Nombre", 25, "Magico");
INSERT INTO Ataques VALUES("Ataque emocional", 35, "Magico");

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Esqueleto");
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Esqueleto");

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Slime");
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Slime");

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Zombie");
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Zombie");

INSERT INTO Ataque_Enemigo VALUES("Felonia Simpatica", "Imp");
INSERT INTO Ataque_Enemigo VALUES("Invocar Nombre", "Imp");

INSERT INTO Ataque_Enemigo VALUES("Felonia Simpatica", "Bruja");
INSERT INTO Ataque_Enemigo VALUES("Invocar Nombre", "Bruja");
INSERT INTO ataque_enemigo VALUES("Ataque emocional", "Bruja");

INSERT INTO Ataque_Enemigo VALUES("Felonia Simpatica", "Vampiro");
INSERT INTO Ataque_Enemigo VALUES("Invocar Nombre", "Vampiro");
INSERT INTO ataque_enemigo VALUES("Ataque emocional", "Vampiro");

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Demonio");
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Demonio");
INSERT INTO ataque_enemigo VALUES("Ataque emocional", "Demonio");

INSERT INTO Ataque_Enemigo VALUES("Golpe", "Perro Infectado");
INSERT INTO Ataque_Enemigo VALUES("Estocada", "Perro Infectado");
INSERT INTO Armas VALUES ("Baston", "sw", 32,22,11,33,44);
INSERT INTO Ataque_personaje VALUES ("Golpe de los 50 Brazos", "sw");
INSERT INTO Ataque_personaje VALUES ("Felonia Simpatica", "sw");
INSERT INTO Ataque_personaje VALUES ("Estocada", "sw");
