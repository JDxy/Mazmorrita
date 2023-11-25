package com.project.mazmorrita_project.models;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;
import static com.project.mazmorrita_project.models.SingInModel.findUser;

public class TestEliminaralfinalizarelproyecto {
    public static void main(String[] args)  {

        String[] listValues = new String[2];
        listValues[0] = "Ana";
        listValues[1] = "123";

        List<HashMap<String, String>> sql = ExecuteSelectSql("SELECT id, nombre, contraseña FROM usuarios WHERE nombre = ? AND contraseña = ?", listValues);

        for (HashMap<String, String> row : sql) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                String columnName = entry.getKey();
                String value = entry.getValue();
                System.out.println(columnName + ": " + value);
            }
            System.out.println("---"); // Separador entre filas
        }

        if(findUser("Ana","123")){
            System.out.println("Todo chido");
        }else {
            System.out.println("No chido");
        };

    }
}

