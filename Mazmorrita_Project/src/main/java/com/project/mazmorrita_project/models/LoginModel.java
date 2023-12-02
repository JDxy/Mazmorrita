package com.project.mazmorrita_project.models;

import static com.project.mazmorrita_project.models.LocalConnection.findValue;

public class LoginModel {

    public static boolean findUser(String userName, String password) {
        String[] listValues = new String[2];
        listValues[0] = userName;
        listValues[1] = password;

        return  findValue("SELECT id, nombre FROM usuarios WHERE nombre = ? AND contraseña = ?", listValues);
    }

}




