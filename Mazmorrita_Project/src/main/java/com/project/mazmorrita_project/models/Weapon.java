package com.project.mazmorrita_project.models;

public class Weapon {

    private String nombre;
    private int defensa;
    private int fuerza;
    private int vida;
    private int magia;
    private int mana;

    public Weapon(String nombre, int defensa, int fuerza, int vida, int magia, int mana) {
        this.nombre = nombre;
        this.defensa = defensa;
        this.fuerza = fuerza;
        this.vida = vida;
        this.magia = magia;
        this.mana = mana;
    }

    public String getNombre() {
        return nombre;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getFuerza() {
        return fuerza;
    }
    public int getVida() {
        return vida;
    }
    public int getMagia() {
        return magia;
    }
    public int getMana() {
        return mana;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setMagia(int magia) {
        this.magia = magia;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
}
