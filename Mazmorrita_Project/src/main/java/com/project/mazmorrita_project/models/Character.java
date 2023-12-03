package com.project.mazmorrita_project.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LocalConnection.*;

public class Character {
    public static Character character;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public ArrayList<Weapon> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Weapon> armas) {
        this.armas = armas;
    }

    public ArrayList<Attack> getAtaques() {
        return ataques;
    }

    public void setAtaques(ArrayList<Attack> ataques) {
        this.ataques = ataques;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

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

    public static List<Character> showCharacters(String userId, String type) {
        String[] listValues = new String[1];
        listValues[0] = userId;
        String sql;
        if (type.equals("IdUsuario")){
            sql = "SELECT * FROM personajes WHERE IdUsuario = ?";
        }else {
            sql = "SELECT * FROM personajes WHERE Nombre = ?";
        }
        List<HashMap<String, String>> sqlResult = ExecuteSelectSql(sql, listValues);

        List<Character> characters = new ArrayList<>();

        for (HashMap<String, String> row : sqlResult) {
            Character character = createCharacterFromHashMap(row);
            characters.add(character);
        }

        return characters;
    }

    private static Character createCharacterFromHashMap(HashMap<String, String> characterData) {
        String nombre = characterData.get("Nombre");
        String avatarPath = characterData.get("Avatar");
        int idUsuario = Integer.parseInt(characterData.get("IdUsuario"));
        int vida = Integer.parseInt(characterData.get("Vida"));
        int fuerza = Integer.parseInt(characterData.get("Fuerza"));
        int defensa = Integer.parseInt(characterData.get("Defensa"));
        int magia = Integer.parseInt(characterData.get("Magia"));
        int mana = Integer.parseInt(characterData.get("Mana"));
        String clase = characterData.get("Clase");
        int piso = Integer.parseInt(characterData.get("IdPiso"));
        int experiencia = Integer.parseInt(characterData.get("Experiencia"));

        return new Character(nombre, avatarPath, idUsuario, vida, fuerza, defensa, magia, mana, clase, piso, experiencia);
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
