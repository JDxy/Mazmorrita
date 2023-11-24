package com.project.mazmorrita_project.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

public class RegisterModel {



   public static void crearUsuario(String nombre, String password){
        String[] listValues = new String[2];
        listValues[0]=nombre;
        listValues[1]=password;
        LocalConnection.insertMethod("usuarios","Nombre, Contraseña",listValues, "?,?");
   }

}
