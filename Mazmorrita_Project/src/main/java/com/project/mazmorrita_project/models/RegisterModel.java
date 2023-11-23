package com.project.mazmorrita_project.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

public class RegisterModel {
public static void main(String[] args) throws SQLException {
    String[] listValues =  new String[2];
    listValues[0] = "dddd";
    listValues[1] = "contraseña";


    HashMap<String, String> sql = null;

    ExecuteChangesSql("INSERT INTO usuarios (nombre, contraseña) VALUES(?, ?)", listValues);
    /*
    ExecuteChangesSql("UPDATE usuarios set nombre = ?  WHERE id = ?", listValues);
*/
    sql = ExecuteSelectSql("SELECT id, nombre, contraseña FROM usuarios WHERE nombre = ? AND contraseña = ?" , listValues);

    for (Map.Entry e: sql.entrySet()
         ) {
        System.out.println(e);
    }
}

   public static void crearUsuario(String nombre, String password){
        String[] listValues = new String[2];
        listValues[0]=nombre;
        listValues[1]=password;
        LocalConnection.insertMethod("usuarios","Nombre, Contraseña",listValues, "?,?");
   }


}
