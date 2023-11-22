package com.project.mazmorrita_project.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalConnection {
    private static final String url = "jdbc:mysql://localhost:3306/proyectomazmorrita";
    private static final String user = "root";
    private static final String password = "1234";
    private static Connection connect = null;

    public static Connection getConnection() {
        try {
            if (connect == null || connect.isClosed()) {
                connect = DriverManager.getConnection(url, user, password);
                System.out.println("¡Conexión exitosa!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connect;
    }

    public static void closeConnection() {
        if (connect != null) {
            try {
                connect.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            } finally {
                connect = null;
            }
        }
    }
    
    public static void insertMethod(String nombre_tabla, String list_columns, String[] list_values, String exclamations){
        Connection connect = LocalConnection.getConnection();
        if (connect != null) {
            try {
                String sql = "INSERT INTO " + nombre_tabla + " (" + list_columns + ") VALUES ("+ exclamations +")";
                PreparedStatement statement = connect.prepareStatement(sql);
                for (int i = 1; i < list_values.length; i++){
                    statement.setString(i, list_values[i]);
                }
                int filasInsertadas = statement.executeUpdate();
                System.out.println("Filas afectadas: " + filasInsertadas);

            } catch (SQLException e) {
                System.out.println("Error al insertar datos: " + e.getMessage());
            } finally {
                LocalConnection.closeConnection();
            }
        }
    }
    
}
