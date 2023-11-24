package com.project.mazmorrita_project.models;

import javafx.scene.image.Image;

public class CreateCharacterModel {

    public static void crearPersonaje(String nombre, Image avatar, int idUsuario, int vida, int fuerza, int defensa, int magia, int mana, String clase){

        String[] listValues = new String[8];
        listValues[0]=nombre;
        listValues[1]= String.valueOf(idUsuario);
        listValues[2]=String.valueOf(vida);
        listValues[3]=String.valueOf(fuerza);
        listValues[4]=String.valueOf(defensa);
        listValues[5]=String.valueOf(magia);
        listValues[6]=String.valueOf(mana);
        listValues[7]=String.valueOf(clase);
//No funciona :)
        LocalConnection.ExecuteSelectSql("INSERT INTO proyectomazmorrita.personajes (Nombre, Avatar, IdUsuario, Vida, Fuerza, Defensa, Magia, Mana, Clase) values ",listValues);
    }

}
