package com.project.mazmorrita_project.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
                for (int i = 0; i < list_values.length; i++){
                    statement.setString(i+1, list_values[i]);
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

    public static HashMap<String, String> ExecuteSelectSql(String sql, String[] values) {
        Connection connect = LocalConnection.getConnection();
        ResultSet resultSet = null;
        HashMap<String,String> result = new HashMap<>();
        if (connect != null) {
            try {
                PreparedStatement statement = connect.prepareStatement(sql);
                for (int i = 0; i < values.length; i++) {
                    statement.setString(i + 1, values[i]);
                }

                resultSet = statement.executeQuery();

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object value = resultSet.getObject(columnName);

                        result.put(columnName,  String.valueOf(value)          );
                    }
                }

                return result;

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return null;
            } finally {
                LocalConnection.closeConnection();
            }
        }else {
            return null;
        }

    }


    public static boolean ExecuteChangesSql(String sql, String[] values) {
        Connection connect = LocalConnection.getConnection();
        if (connect != null) {
            try {
                PreparedStatement statement = connect.prepareStatement(sql);
                for (int i = 0; i < values.length; i++) {
                    statement.setString(i + 1, values[i]);
                }
                int filasAfectadas = statement.executeUpdate();
                System.out.println("Filas afectadas: " + filasAfectadas);
                return true;
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            } finally {
                LocalConnection.closeConnection();
            }
        }
        return false;
    }
    
}
