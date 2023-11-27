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
    public Pane Panel1, Panel2, Panel3, Panel4, Panel5;
    @FXML
    public ImageView ImageView1, ImageView2, ImageView3, ImageView4, ImageView5;
    @FXML
    public Label Name1, Name2, Name3, Name4, Name5;
    @FXML
    public Label Experience1, Experience2, Experience3, Experience4, Experience5;

    public void initialize() {
        List<HashMap<String, String>> characters = showCharacters(SignInController.id);

        Pane[] panels = {Panel1, Panel2, Panel3, Panel4, Panel5};
        ImageView[] imageViews = {ImageView1, ImageView2, ImageView3, ImageView4, ImageView5};
        Label[] names = {Name1, Name2, Name3, Name4, Name5};
        Label[] experiences = {Experience1, Experience2, Experience3, Experience4, Experience5};

        for (int i = 0; i < characters.size(); i++) {
            panels[i].setVisible(true);
            HashMap<String, String> character = characters.get(i);

            for (Map.Entry<String, String> entry : character.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if ("Avatar".equals(key)) {
                    Image image = new Image("file:" + value);
                    imageViews[i].setImage(image);
                } else if ("Nombre".equals(key)) {
                    names[i].setText(value);
                } else if ("Experiencia".equals(key)) {
                    experiences[i].setText(value);
                }
            }
        }
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
