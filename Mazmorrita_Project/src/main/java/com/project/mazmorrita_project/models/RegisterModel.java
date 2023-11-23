package com.project.mazmorrita_project.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSql;

public class RegisterModel {
    public static void main(String[] args) {

        String listColumns = "nombre,contraseña";

        String[] listValues =  new String[2];

        listValues[0] = "dddd";
        listValues[1] = "contraseña";


        ExecuteSql("INSERT INTO usuarios (nombre,contraseña) VALUES (?, ?)", listValues);
    }

}
