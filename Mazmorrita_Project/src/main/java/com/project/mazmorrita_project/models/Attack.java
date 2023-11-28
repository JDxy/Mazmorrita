package com.project.mazmorrita_project.models;

import javafx.fxml.FXML;

//He declarado esta clase solo para que no me de fallos la construccion de los enemigos
//Ya le dejo al encargado de esta como la termina de hacer
public class Attack {
    private  String nombre;
    private int potencia;
    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public Attack(String nombre, int potencia, String tipo) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.tipo = tipo;
    }
}
