package com.project.mazmorrita_project.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

public class AttackPj {
    private String nombre;
    private int idUsuario;
    private String nombreUsuario;

    public AttackPj(String nombre,int idUsuario, String nombreUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
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
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public static void generarNombresAttacksMago(String nombrePersonaje, int idUsuario) {

        File file = new File("Mazmorrita_Project/src/main/resources/Files/AttackMago.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] values;
            while ((line = bufferedReader.readLine()) != null) {
                values= new String[]{line.trim(), String.valueOf(idUsuario), nombrePersonaje};
                LocalConnection.ExecuteChangesSql("INSERT INTO ataque_personaje (NombreAtaque, IdUsuario, NombrePersonaje) VALUES (?, ?, ?);",values);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de ataques", e);
        }
    }
    public static void generarNombresAttacksPicaro(String nombrePersonaje, int idUsuario) {

        File file = new File("Mazmorrita_Project/src/main/resources/Files/AttackPicara.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] values;
            while ((line = bufferedReader.readLine()) != null) {
                values= new String[]{line.trim(), String.valueOf(idUsuario), nombrePersonaje};
                LocalConnection.ExecuteChangesSql("INSERT INTO ataque_personaje (NombreAtaque, IdUsuario, NombrePersonaje) VALUES (?, ?, ?);",values);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de ataques", e);
        }
    }
    public static void generarNombresAttacksBarbaro(String nombrePersonaje, int idUsuario) {

        File file = new File("Mazmorrita_Project/src/main/resources/Files/AttackBarbaro.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] values;
            while ((line = bufferedReader.readLine()) != null) {
                values= new String[]{line.trim(), String.valueOf(idUsuario), nombrePersonaje};
                LocalConnection.ExecuteChangesSql("INSERT INTO ataque_personaje (NombreAtaque, IdUsuario, NombrePersonaje) VALUES (?, ?, ?);",values);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de ataques", e);
        }
    }
    public static List<AttackPj> mostrarAtaquesPersonajes(String namePj, String UserId) {
        String[] listValues = new String[2];
        listValues[0] = namePj;
        listValues[1] = UserId;
        String sql;
        sql = "SELECT * FROM ataque_personaje WHERE NombrePersonaje = ? AND idUsuario = ?;";
        List<HashMap<String, String>> sqlResult = ExecuteSelectSql(sql, listValues);
        List<AttackPj> attacksPj = new ArrayList<>();
        for (HashMap<String, String> row : sqlResult) {
            AttackPj attackPj=generarAtaquesPersonajesParaConsulta(row);
            attacksPj.add(attackPj);
        }
        return attacksPj;
    }
    private static AttackPj generarAtaquesPersonajesParaConsulta(HashMap<String, String> attacksPjData) {
        String nombrePj = attacksPjData.get("NombreAtaque");
        int idUsuario = Integer.parseInt(attacksPjData.get("IdUsuario"));
        String nombreUsuario = attacksPjData.get("NombrePersonaje");
        return new AttackPj(nombrePj,idUsuario,nombreUsuario);
    }


}