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

    public static List<HashMap<String, String>> ExecuteSelectSql(String sql, String[] values) {
        Connection connect = LocalConnection.getConnection();
        ResultSet resultSet = null;
        List<HashMap<String, String>> resultList = new ArrayList<>();

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
                System.out.println("Error: " + e.getMessage());
                return null;
            } finally {
                LocalConnection.closeConnection();
            }
        } else {
            return null;
        }
    }


    public static boolean ExecuteChangesSql(String sql, Object[] values) {
        Connection connect = LocalConnection.getConnection();
        if (connect != null) {
            PreparedStatement statement = null;
            try {
                statement = connect.prepareStatement(sql);

                for (int i = 0; i < values.length; i++) {
                    Object value = values[i];

                    if (value instanceof byte[]) {
                        statement.setBytes(i + 1, (byte[]) value);
                    } else {
                        statement.setString(i + 1, String.valueOf(value));
                    }
                }

                int filasAfectadas = statement.executeUpdate();
                System.out.println("Filas afectadas: " + filasAfectadas);
                return true;

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            } finally {
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
    
}
