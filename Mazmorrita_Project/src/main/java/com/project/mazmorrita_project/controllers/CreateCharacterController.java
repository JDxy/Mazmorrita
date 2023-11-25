package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

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
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor.fxml")));
            Stage window= (Stage) crearPersonajeTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void claseMago(MouseEvent mouseEvent) {
    }
    public void claseBarbaro(MouseEvent mouseEvent) {
    }
    public void clasePicaro(MouseEvent mouseEvent) {
    }
}
