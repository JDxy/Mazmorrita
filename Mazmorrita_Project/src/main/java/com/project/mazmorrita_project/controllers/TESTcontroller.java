package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.CreateCharacterModel;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

public class TESTcontroller {

    @FXML
    private ImageView imageView;

    public void initialize() {
        String sql = "SELECT avatar FROM Personajes WHERE nombre = ?"; // Asegúrate de ajustar la consulta para obtener la imagen del personaje correcto
        String[] values = { "personaje2" }; // Reemplaza ID_DEL_PERSONAJE con el ID real del personaje que deseas cargar

        List<HashMap<String, String>> resultList = ExecuteSelectSql(sql, values);

        if (resultList != null && !resultList.isEmpty()) {
            HashMap<String, String> characterData = resultList.get(0);
            String imagePath = characterData.get("Avatar");

            // Verifica si la ruta de la imagen no es nula o vacía
            if (imagePath != null && !imagePath.isEmpty()) {
                // Cargar la imagen desde la ruta
                Image image = new Image("file:" + imagePath);
                System.out.println(imagePath);
                // Establecer la imagen en el ImageView
                imageView.setImage(image);
            } else {
                System.out.println("La ruta de la imagen está vacía o es nula");
            }
        } else {
            System.out.println("No se encontraron datos para el personaje con ID proporcionado");
        }
    }

    public static void main(String[] args) {

/*
        String [] listValues = new String[2];

        listValues[0] = "dd";
        listValues[1] = "dd";

        ExecuteChangesSql("INSERT INTO usuarios(nombre, contraseña) values (?,?)", listValues);
*/

      /*
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
*/
        String sql = "SELECT * FROM Personajes";
        String[] values = new String[0];

        List<HashMap<String, String>> resultList = ExecuteSelectSql(sql, values);
    }

}
