package com.project.mazmorrita_project.models;

import javafx.scene.image.Image;

public class CreateCharacterModel {

    public static void crearPersonaje(String nombre,String avatar, int idUsuario, int vida, int fuerza, int defensa, int magia, int mana,
                                      String clase, int piso, int experiencia) {

        String[] listValues = new String[11];
        listValues[0] = nombre;
        listValues[1] = String.valueOf(idUsuario);
        listValues[2] = String.valueOf(vida);
        listValues[3] = String.valueOf(fuerza);
        listValues[4] = String.valueOf(defensa);
        listValues[5] = String.valueOf(magia);
        listValues[6] = String.valueOf(mana);
        listValues[7] = String.valueOf(clase);
        listValues[8] = String.valueOf(piso);
        listValues[9] = String.valueOf(experiencia);
        listValues[10] = String.valueOf(avatar);

        LocalConnection.ExecuteChangesSql("INSERT INTO personajes (Nombre, IdUsuario, Vida, Fuerza, Defensa, Magia, Mana, Clase, idpiso, Experiencia ,Avatar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", listValues);
    }




}
