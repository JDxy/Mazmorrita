package com.project.mazmorrita_project.models;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;

public class SingInModel {
    private static boolean findUser(String userName, String password) {
        String[] listValues = new String[2];
        listValues[0] = userName;
        listValues[1] = password;

        if (ExecuteChangesSql("SELECT usuarios WHERE nombre = ? AND contraseña = ?", listValues)) {

        };
        return false;
    }
}

