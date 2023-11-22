package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {
    @FXML
    public Label iniciarSesionTitle;

    public void iniciarSesion(MouseEvent mouseEvent) {
    }

    public void cancelar(MouseEvent mouseEvent) {

        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Login.fxml")));
            Stage window= (Stage) iniciarSesionTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
