package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.mazmorrita_project.models.Character.showCharacters;

public class SelectCharacterController {
    @FXML
    public Label seleccionPersonajeTitle;

    @FXML
    public ImageView ImageView1;

    @FXML
    public Label Name1;

    @FXML
    public Label Experience1;

    @FXML
    public Pane Panel1;
    public void initialize() {
        List<HashMap<String, String>> characters = showCharacters("3");

        Panel1.setVisible(true);
        for (HashMap<String, String> character : characters) {
            for (Map.Entry<String, String> entry : character.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if ("Avatar".equals(key)) {
                    Image image = new Image("file:" + value);
                    ImageView1.setImage(image);
                } else if ("Nombre".equals(key)) {
                    Name1.setText(value);
                } else if ("Experiencia".equals(key)) {
                    Experience1.setText(value);
                }
            }
        }
        System.out.println();
    }

    public void crearPersonaje(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/CreateCharacter.fxml")));
            Stage window= (Stage) seleccionPersonajeTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("CreateCharacter");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void atras(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Login.fxml")));
            Stage window= (Stage) seleccionPersonajeTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrarPersonaje(MouseEvent mouseEvent) {
    }
}
