package com.project.mazmorrita_project.models;

import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

//He declarado esta clase solo para que no me de fallos la construccion de los enemigos
//Ya le dejo al encargado de esta como la termina de hacer
public class Attack {
    private  String nombre;
    private int potencia;
    private String tipo;

    public Attack(String nombre,int potencia, String tipo) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.tipo = tipo;
    }
    public Attack(String nombre) {
        this.nombre = nombre;
        this.potencia = 0;
        this.tipo = null;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPotencia() {
        return potencia;
    }
    public String getTipo() {
        return tipo;
    }


    public static List<Attack> showAttacks(String namePj, String UserId) {
        String[] listValues = new String[2];
        listValues[0] = namePj;
        listValues[1] = UserId;
        String sql;
        sql = "SELECT * FROM ataques INNER JOIN Ataque_personaje AS aP ON Ataques.Nombre = aP.NombreAtaque  WHERE aP.NombrePersonaje = ? AND aP.idUsuario = ?;";
        List<HashMap<String, String>> sqlResult = ExecuteSelectSql(sql, listValues);
        List<Attack> attacks = new ArrayList<>();
        for (HashMap<String, String> row : sqlResult) {
            Attack attack = createAttackFromHashMap(row);
            attacks.add(attack);
        }
        return attacks;
    }
    private static Attack createAttackFromHashMap(HashMap<String, String> attackData) {
        String nombre = attackData.get("Nombre");
        int potencia = Integer.parseInt(attackData.get("Potencia"));
        String tipo = attackData.get("Tipo");
        return new Attack(nombre, potencia, tipo);
    }


    public static void insertarPaloMadera(){

    }

}
