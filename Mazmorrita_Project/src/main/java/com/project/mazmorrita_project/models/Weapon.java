package com.project.mazmorrita_project.models;

import com.project.mazmorrita_project.controllers.SelectCharacterController;
import com.project.mazmorrita_project.controllers.LoginController;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

public class Weapon {
    private String nombre;
    private int fuerza;
    private int defensa;
    private int vida;
    private int magia;
    private int mana;
/*
    public Weapon(String nombre) {
        this.nombre = nombre;
        this.idUsuario = Integer.parseInt(LoginController.id);
        this.nombrePersonaje = SelectCharacterController.nameSelected;
        this.fuerza = (int) (Math.random()*5+1);
        this.defensa = (int) (Math.random()*5+1);
        this.vida = (int) (Math.random()*5+1);
        this.magia = (int) (Math.random()*5+1);
        this.mana = (int) (Math.random()*5+1);
    }
 */
    public Weapon(String nombre, int fuerza, int defensa, int vida, int magia, int mana) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.vida = vida;
        this.magia = magia;
        this.mana = mana;
    }
    public static Weapon generateWeapon(String nombre) {
        String nombrePersonaje = SelectCharacterController.nameSelected;
        int fuerza = (int) (Math.random() * 5 + 1);
        int defensa = (int) (Math.random() * 5 + 1);
        int vida = (int) (Math.random() * 5 + 1);
        int magia = (int) (Math.random() * 5 + 1);
        int mana = (int) (Math.random() * 5 + 1);
        return new Weapon(nombre, fuerza, defensa, vida, magia, mana);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
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
    /**
     * metodo generarArmasDesdeArchivo
     * lee la ruta del fichero weapons.txt para crear armas nuevas
     * @return
     */
    public static Weapon generarArmasDesdeArchivo() {
        List<Weapon> weapons = new ArrayList<>();
        File file=new File("Mazmorrita_Project/src/main/resources/Files/Weapons.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(String.valueOf(file))))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Weapon weapon = generateWeapon(line.trim());
                weapons.add(weapon);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de armas", e);
        }
        return weapons.get(0);
    }
    public static List<Weapon> showWeapon(String namePj, String userId) {
        String[] listValues = new String[2];
        listValues[0] = namePj;
        listValues[1] = userId;
        String sql;
        sql = "SELECT * FROM Armas WHERE NombrePersonaje = ? AND IdUsuario = ?";
        List<HashMap<String, String>> sqlResult = ExecuteSelectSql(sql, listValues);
        List<Weapon> weapons = new ArrayList<>();
        for (HashMap<String, String> row : sqlResult) {
            Weapon weapon = createWeaponFromHashMap(row);
            weapons.add(weapon);
        }
        return weapons;
    }
    private static Weapon createWeaponFromHashMap(HashMap<String, String> weaponData) {
        String nombre = weaponData.get("Nombre");
        String nombrePersonaje = weaponData.get("NombrePersonaje");
        int fuerza = Integer.parseInt(weaponData.get("Fuerza"));
        int defensa = Integer.parseInt(weaponData.get("Defensa"));
        int vida = Integer.parseInt(weaponData.get("Vida"));
        int magia = Integer.parseInt(weaponData.get("Magia"));
        int mana = Integer.parseInt(weaponData.get("Mana"));
        return new Weapon(nombre, fuerza, vida, defensa, magia, mana);
    }
    public static void deleteWeaponTable(String nameChar, String idUser){
        String sqlSentence= "DELETE FROM armas where NombrePersonaje = (SELECT Nombre FROM personajes WHERE Nombre = ? and IdUsuario = ?);";
        String[] values = new String[2];
        values[0]= nameChar;
        values[1]= idUser;
        LocalConnection.ExecuteChangesSql(sqlSentence, values);
    }
    /**
     * Método insertarPaloMadera
     * este metodo inserta un arma por defecto en la tabla cuando creas el personaje
     * @param nombrePersonaje
     * @param id
     */
    public static void insertarPaloMadera(String nombrePersonaje, int id){
        String[]values=new String[8];
        values[0]="Palo de Madera";
        values[1]=nombrePersonaje;
        values[2]=String.valueOf(id);
        values[3]="1";
        values[4]="1";
        values[5]="1";
        values[6]="1";
        values[7]="1";
        String sql= "INSERT INTO armas (Nombre, NombrePersonaje, IdUsuario, Fuerza, Defensa, Vida, Magia, Mana) VALUES (?,?,?,?,?,?,?,?);";
        LocalConnection.ExecuteChangesSql(sql,values);
    }
}
