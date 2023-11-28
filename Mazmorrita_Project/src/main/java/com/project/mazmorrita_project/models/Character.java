package com.project.mazmorrita_project.models;

import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LocalConnection.*;

public class Character {

    public static List<HashMap<String, String>> showCharacters(String userId){
        String[] listValues = new String[1];
        listValues[0] = userId;
        List<HashMap<String, String>> sql= ExecuteSelectSql("SELECT avatar, nombre, experiencia FROM personajes WHERE IdUsuario = ?", listValues);
        return sql;
    }


    public static void deleteCharacter(String name){
        String[] listValues = new String[1];
        listValues[0] = name;
        LocalConnection.ExecuteChangesSql("DELETE FROM personajes WHERE nombre = ?", listValues);
    }

    public static boolean findCharacter(String name){
        String[] listValues = new String[1];
        listValues[0] = name;

       return findValue("SELECT nombre FROM personajes WHERE nombre = ?", listValues);
    }

    public static boolean noMoreThan5(int userId){
        String[] listValues = new String[1];
        listValues[0] = String.valueOf(userId);
        System.out.println(userId);
        List<HashMap<String, String>> sql =  ExecuteSelectSql("SELECT idUsuario FROM personajes WHERE idUsuario = ?", listValues);

        if (sql.size() <= 5){

            System.out.println(sql.size());

            return true;
        }
        return false;
    }

    public static void createCharacter(String nombre, String avatar, int idUsuario, int vida, int fuerza, int defensa, int magia, int mana,
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
