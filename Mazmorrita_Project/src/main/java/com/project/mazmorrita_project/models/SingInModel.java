package com.project.mazmorrita_project.models;

import java.util.HashMap;
import java.util.Map;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

public class SingInModel {


    public static boolean findUser(String userName, String password) {
        String[] listValues = new String[2];
        listValues[0] = userName;
        listValues[1] = password;
        HashMap<String, String> sql = ExecuteSelectSql("SELECT id, nombre FROM usuarios WHERE nombre = ? AND contraseña = ?", listValues);
        int count = 0;
        if (sql != null ){
            return true;
        }
        return false;
    }


}




