package com.project.mazmorrita_project.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterModel {
    public static void main(String[] args) {

        String listColumns = "nombre, contraseña";

        String[] listValues =  new String[3];
        listValues[0] = "";
        listValues[1] = "dddd";
        listValues[2] = "contraseña";


        LocalConnection.insertMethod("usuarios",listColumns , listValues);

    }

}
