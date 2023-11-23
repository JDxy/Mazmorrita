package com.project.mazmorrita_project.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSql;
import static com.project.mazmorrita_project.models.LocalConnection.getConnection;

public class RegisterModel {
   /* public static void main(String[] args) {
        String listColumns = "nombre,contraseña";
        String[] listValues =  new String[2];
        listValues[0] = "dddd";
        listValues[1] = "contraseña";
        ExecuteSql("INSERT INTO usuarios (nombre,contraseña) VALUES (?, ?)", listValues);
    }
    */
   public static void crearUsuario(String nombre, String password){
        String[] listValues = new String[2];
        listValues[0]=nombre;
        listValues[1]=password;
        LocalConnection.insertMethod("usuarios","Nombre, Contraseña",listValues, "?,?");
   }


}
