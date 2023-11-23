package com.project.mazmorrita_project.models;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;
import static com.project.mazmorrita_project.models.SingInModel.findUser;

public class TestEliminaralfinalizarelproyecto {


    public static void main(String[] args)  {
        if(findUser("dddd","contraseña")){
            System.out.println("Todo chido");
        }else {
            System.out.println("No chido");
        };

    }
}

