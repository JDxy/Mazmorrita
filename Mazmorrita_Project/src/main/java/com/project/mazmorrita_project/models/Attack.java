package com.project.mazmorrita_project.models;

import javafx.fxml.FXML;

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

    public static List<Attack> showAttacks(String namePj) {
        String[] listValues = new String[1];
        listValues[0] = namePj;
        String sql;
        sql = "SELECT ataques.*\n" +
                "FROM Ataques \n" +
                "INNER JOIN Ataque_personaje AS aP \n" +
                "ON Ataques.Nombre = aP.NombreAtaque \n" +
                "WHERE aP.NombrePersonaje = ?;";
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
}
