package com.project.mazmorrita_project.models;

import javafx.scene.image.Image;

public class Personaje {
    private String nombre;
    private int idUsuario;
    private Image avatar;
    private int vida;
    private int fuerza;
    private int defensa;
    private int magia;
    private int mana;
    private int experiencia;

    public Personaje(String nombre, Image avatar, int vida, int fuerza, int defensa, int magia, int mana) {
        this.nombre = nombre;
        //idUsuario=0;¿?
        this.avatar = avatar;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.magia = magia;
        this.mana = mana;
        experiencia=0;
    }
    public String getNombre() {
        return nombre;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public Image getAvatar() {
        return avatar;
    }
    public int getVida() {
        return vida;
    }
    public int getFuerza() {
        return fuerza;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getMagia() {
        return magia;
    }
    public int getMana() {
        return mana;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public void setMagia(int magia) {
        this.magia = magia;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
