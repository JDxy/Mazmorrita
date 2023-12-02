package com.project.mazmorrita_project.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalConnection {
    private static final String url = "jdbc:mysql://localhost:3306/proyectomazmorrita";
    private static final String user = "root";
    private static final String password = "1234";
    private static Connection connect = null;


    /**
     * Método para obtener una conexión a la base de datos.
     * @return Connection - Objeto de conexión a la base de datos.
     */
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

    /**
     * Método para cerrar la conexión a la base de datos.
     */
    public static void closeConnection() {
        if (connect != null) {
            try {
                // Cierra la conexión con la base de datos
                connect.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                // Manejo de excepciones al cerrar la conexión
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            } finally {
                // Establece la conexión como nula una vez cerrada
                connect = null;
            }
        }
    }

    /**
     * Método para ejecutar consultas SELECT en la base de datos y obtener una lista de HashMaps con los resultados.
     * @param sql - Consulta SQL a ejecutar.
     * @param values - Valores de los parámetros de la consulta.
     * @return List<HashMap<String, String>> - Resultados de la consulta.
     */
    public static List<HashMap<String, String>> ExecuteSelectSql(String sql, String[] values) {
        // Obtiene una conexión a la base de datos
        Connection connect = LocalConnection.getConnection();
        ResultSet resultSet = null;
        List<HashMap<String, String>> resultList = new ArrayList<>();

        if (connect != null) {
            try {
                // Prepara la consulta SQL
                PreparedStatement statement = connect.prepareStatement(sql);
                // Asigna los valores a la consulta preparada
                if (values != null) {
                    for (int i = 0; i < values.length; i++) {
                        statement.setString(i + 1, values[i]);
                    }
                }
                resultSet = statement.executeQuery();

                // Procesa los resultados y los almacena en una lista de HashMaps
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    HashMap<String, String> row = new HashMap<>();

                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object value = resultSet.getObject(columnName);
                        row.put(columnName, String.valueOf(value));
                    }
                    resultList.add(row);
                }

                return resultList;

            } catch (SQLException e) {
                // Manejo de excepciones en caso de error en la consulta
                System.out.println("Error: " + e.getMessage());
                return null;
            } finally {
                // Cierra la conexión a la base de datos
                LocalConnection.closeConnection();
            }
        } else {
            return null;
        }
    }

    /**
     * Método para ejecutar consultas de cambios (INSERT, UPDATE, DELETE) en la base de datos.
     * @param sql - Consulta SQL a ejecutar.
     * @param values - Valores de los parámetros de la consulta.
     * @return boolean - True si la consulta se realizó con éxito, False en caso contrario.
     */
    public static boolean ExecuteChangesSql(String sql, Object[] values) {
        Connection connect = LocalConnection.getConnection();
        if (connect != null) {
            PreparedStatement statement = null;
            try {
                statement = connect.prepareStatement(sql);
                for (int i = 0; i < values.length; i++) {
                    Object value = values[i];
                    statement.setString(i + 1, String.valueOf(value));
                }

                // Ejecuta la consulta de cambios y devuelve true si se realizan con éxito
                int filasAfectadas = statement.executeUpdate();
                System.out.println("Filas afectadas: " + filasAfectadas);
                return true;

            } catch (SQLException e) {
                // Manejo de excepciones en caso de error en la consulta
                System.out.println("Error: " + e.getMessage());
                return false;
            } finally {
                // Cierra el PreparedStatement y la conexión a la base de datos
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                LocalConnection.closeConnection();
            }
        }
        return false;
    }

    /**
     * Método para verificar si se encuentra algún valor según una consulta SELECT.
     * @param select - Consulta SELECT a ejecutar.
     * @param listValues - Valores de los parámetros de la consulta.
     * @return boolean - True si se encuentra algún valor, False en caso contrario.
     */
    public static boolean findValue(String select, String[] listValues){
        List<HashMap<String, String>> sql = ExecuteSelectSql(select, listValues);
        if (sql != null && !sql.isEmpty()) {
            return true;
        }
        return false;
    }
}


