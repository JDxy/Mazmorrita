package com.project.mazmorrita_project.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/proyectomazmorrita";
        String usuario = "root";
        String contraseña = "1234";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("¡Conexión exitosa!");

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
