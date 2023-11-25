package com.project.mazmorrita_project.models;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.mazmorrita_project.models.CreateCharacterModel.crearPersonaje;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;
import static com.project.mazmorrita_project.models.SingInModel.findUser;

public class TestEliminaralfinalizarelproyecto {
    public static void main(String[] args)  {

        String[] listValues = new String[2];
        listValues[0] = "Ana";
        listValues[1] = "123";

            String nombre = "Personaje2";
            int idUsuario = 1;
            int vida = 100;
            int fuerza = 50;
            int defensa = 30;
            int magia = 70;
            int experiencia = 3;
            int mana = 80;
            int piso = 1;
            String clase = "Barbaro";
            String imagePath = "C:\\Users\\josed\\Documents\\GitHub\\Mazmorrita\\Mazmorrita_Project\\src\\main\\resources\\Images\\Characters\\barbaro.jpg";

            CreateCharacterModel.crearPersonaje(nombre, imagePath,idUsuario, vida, fuerza, defensa, magia, mana, clase, piso, experiencia );

            /*
            String [] listValues = new String[2];

            listValues[0] = "dd";
            listValues[1] = "dd";

        ExecuteChangesSql("INSERT INTO usuarios(nombre, contraseña) values (?,?)", listValues, null);
*/
        if(findUser("Ana","123")){
            System.out.println("Todo chido");
        }else {
            System.out.println("No chido");
        };

    }
}

