package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ArmeryController {
    @FXML
    public Label armeriaTitle;
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

    public void cancelar(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Floor.fxml")));
            Stage window= (Stage) armeriaTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Select Character");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarCambios(MouseEvent mouseEvent) {

    }

    public void addMana(MouseEvent mouseEvent) {
    }

    public void addMagia(MouseEvent mouseEvent) {
    }

    public void addVida(MouseEvent mouseEvent) {
    }

    public void addFuerza(MouseEvent mouseEvent) {
    }

    public void addDefensa(MouseEvent mouseEvent) {
    }
}
