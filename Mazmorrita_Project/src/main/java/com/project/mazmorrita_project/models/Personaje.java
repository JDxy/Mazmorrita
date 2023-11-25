package com.project.mazmorrita_project.models;

import javafx.scene.image.Image;

public class Personaje {
    private String nombre;
    private int idUsuario;
    private Imagenes avatar;
    private int vida;
    private int fuerza;
    private int defensa;
    private int magia;
    private int mana;
    private int experiencia;
    private enum Clase  {Mago, Barbaro, Picaro};
    private Clase clase;
    private int idPiso;
    public Personaje(String nombre, Imagenes avatar,Clase clase) {
        this.nombre = nombre;
        //idUsuario=0;¿?
        this.avatar = avatar;
        this.vida = 5;
        this.fuerza = 5;
        this.defensa = 5;
        this.magia = 0;
        this.mana = 0;
        experiencia=0;
        this.clase= clase;
        this.idPiso=1;
    }


    public String getNombre() {
        return nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Imagenes getAvatar() {
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

    public Clase getClase() {
        return clase;
    }

    public int getIdPiso() {
        return idPiso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setAvatar(Imagenes avatar) {
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

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }
}
