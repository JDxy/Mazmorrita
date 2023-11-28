package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Alert;
import com.project.mazmorrita_project.models.Character;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

import static com.project.mazmorrita_project.models.Character.findCharacter;

public class CreateCharacterController {
    @FXML
    public Label crearPersonajeTitle;
    @FXML
    public TextField tFNombre;
    @FXML
    public Label labelDefensa;
    @FXML
    public Label labelFuerza;
    @FXML
    public Label labelVida;
    @FXML
    public Label labelMagia;
    @FXML
    public Label labelMana;
    private String clase=null;

    public static Image imageSelected;

    public void cancelar(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/SelectCharacter.fxml")));
            Stage window= (Stage) crearPersonajeTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("SelectCharacter");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void comenzar(MouseEvent mouseEvent) {
        String nombre = tFNombre.getText();

        if (findCharacter(nombre) != true) {
            if (tFNombre.getText().isEmpty()) {
                Alert.showAlert("Error", "Debe insertar un nombre para el personaje", javafx.scene.control.Alert.AlertType.ERROR);
            } else if (clase == null) {
                Alert.showAlert("Error", "Debe seleccionar una clase", javafx.scene.control.Alert.AlertType.ERROR);
            } else {

                String image = null;
                int idUser = Integer.parseInt(SignInController.id);
                int vida = Integer.parseInt(labelVida.getText());
                int fuerza = Integer.parseInt(labelFuerza.getText());
                int defensa = Integer.parseInt(labelDefensa.getText());
                int magia = Integer.parseInt(labelMagia.getText());
                int mana = Integer.parseInt(labelMana.getText());
                int piso = 1;
                int exp = 0;

                if (clase.equals("Mago")) {
                    image = "Mazmorrita_Project/src/main/resources/Images/Characters/mago.jpg";
                }
                if (clase.equals("Barbaro")) {
                    image = "Mazmorrita_Project/src/main/resources/Images/Characters/barbaro.jpg";
                }
                if (clase.equals("Picaro")) {
                    image = "Mazmorrita_Project/src/main/resources/Images/Characters/picara.jpg";
                }
                imageSelected = new Image("file:" + image);

                Character.createCharacter(nombre, image, idUser, vida, fuerza, defensa, magia, mana, clase, piso, exp);

                try {
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor.fxml")));
                    Stage window = (Stage) crearPersonajeTitle.getScene().getWindow();
                    window.setScene(scene);
                    window.setTitle("floor");
                    window.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            Alert.showAlert("Error", "Este personaje ya existe", javafx.scene.control.Alert.AlertType.ERROR);

        }
    }
    public void claseMago(MouseEvent mouseEvent) {
        labelFuerza.setText("5");
        labelDefensa.setText("5");
        labelMagia.setText("10");
        labelMana.setText("10");
        clase="Mago";
    }
    public void claseBarbaro(MouseEvent mouseEvent) {
        labelFuerza.setText("10");
        labelDefensa.setText("10");
        labelMagia.setText("0");
        labelMana.setText("0");
        clase="Barbaro";
    }
    public void clasePicaro(MouseEvent mouseEvent) {
        labelFuerza.setText("20");
        labelDefensa.setText("5");
        labelMagia.setText("0");
        labelMana.setText("0");
        clase="Picaro";
    }
}
