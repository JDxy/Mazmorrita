package com.project.mazmorrita_project.models;

import com.project.mazmorrita_project.controllers.SelectCharacterController;
import com.project.mazmorrita_project.controllers.LoginController;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Weapon {
    private String nombre;
    private int idUsuario;
    private String nombrePersonaje;
    private int fuerza;
    private int defensa;
    private int vida;
    private int magia;
    private int mana;

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
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombrePersonaje() {
        return nombrePersonaje;
    }
    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
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
    public static List<Weapon> generarArmasDesdeArchivo() {
        List<Weapon> weapons = new ArrayList<>();
        File file=new File("Mazmorrita_Project/src/main/resources/Files/Weapons.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(String.valueOf(file))))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Weapon weapon = new Weapon(line.trim());
                weapons.add(weapon);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de armas", e);
        }
        return weapons;
    }

}
