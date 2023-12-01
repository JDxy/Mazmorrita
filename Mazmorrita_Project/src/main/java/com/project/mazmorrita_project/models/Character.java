package com.project.mazmorrita_project.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LocalConnection.*;

public class Character {

    private String nombre;
    private String avatar;
    private int idUsuario;
    private int vida;
    private int fuerza;
    private int defensa;
    private int magia;
    private int mana;
    private String clase;
    private int piso;
    private int experiencia;
    private ArrayList<Weapon> armas;
    private ArrayList<Attack> ataques;
    private int nivel;

    public Character(String nombre, String avatar, int idUsuario, int vida, int fuerza, int defensa, int magia, int mana, String clase, int piso, int experiencia) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.idUsuario = idUsuario;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.magia = magia;
        this.mana = mana;
        this.clase = clase;
        this.piso = piso;
        this.experiencia = experiencia;
        this.armas = new ArrayList<>();
        this.ataques = new ArrayList<>();
        this.nivel = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public static List<HashMap<String, String>> showCharacters(String userId) {
        String[] listValues = new String[1];
        listValues[0] = userId;
        List<HashMap<String, String>> sql = ExecuteSelectSql("SELECT avatar, nombre, experiencia FROM personajes WHERE IdUsuario = ?", listValues);
        return sql;
    }

    public static List<HashMap<String, String>> showStacksCharacters(String nombrePj) {
        String[] listValues = new String[1];
        listValues[0] = nombrePj;
        List<HashMap<String, String>> sql = ExecuteSelectSql("SELECT Vida, Fuerza, Defensa, Magia, Mana FROM personajes WHERE Nombre = ?", listValues);
        return sql;
    }


    public static void deleteCharacter(String name) {
        String[] listValues = new String[1];
        listValues[0] = name;
        LocalConnection.ExecuteChangesSql("DELETE FROM personajes WHERE nombre = ?", listValues);
    }

    public static boolean findCharacter(String name) {
        String[] listValues = new String[1];
        listValues[0] = name;

        return findValue("SELECT nombre FROM personajes WHERE nombre = ?", listValues);
    }

    public static boolean noMoreThan5(int userId) {
        String[] listValues = new String[1];
        listValues[0] = String.valueOf(userId);

        List<HashMap<String, String>> sql = ExecuteSelectSql("SELECT COUNT(*) AS count FROM personajes WHERE idUsuario = ?", listValues);

        if (!sql.isEmpty()) {
            int count = Integer.parseInt(sql.get(0).get("count"))+1;
            if (count > 5){
                return false;
            }
            return true;
        }
        return true;

    }

    public static void insertCharacter(Character character) {
            String[] listValues = new String[11];
            listValues[0] = character.nombre;
            listValues[1] = String.valueOf(character.idUsuario);
            listValues[2] = String.valueOf(character.vida);
            listValues[3] = String.valueOf(character.fuerza);
            listValues[4] = String.valueOf(character.defensa);
            listValues[5] = String.valueOf(character.magia);
            listValues[6] = String.valueOf(character.mana);
            listValues[7] = String.valueOf(character.clase);
            listValues[8] = String.valueOf(character.piso);
            listValues[9] = String.valueOf(character.experiencia);
            listValues[10] = String.valueOf(character.avatar);

            LocalConnection.ExecuteChangesSql("INSERT INTO personajes (Nombre, IdUsuario, Vida, Fuerza, Defensa, Magia, Mana, Clase, idpiso, Experiencia ,Avatar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", listValues);
        }



}
