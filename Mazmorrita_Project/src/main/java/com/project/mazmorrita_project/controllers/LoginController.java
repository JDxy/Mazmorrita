package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    public Label mazmorritaTitle;

   public void iniciarSesion(MouseEvent actionEvent) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/SignIn.fxml")));
            Stage window= (Stage) mazmorritaTitle.getScene().getWindow();
            window.setTitle("");
            window.setScene(scene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarse(MouseEvent actionEvent) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Register.fxml")));

            Stage window= (Stage) mazmorritaTitle.getScene().getWindow();

            window.setTitle("");
            window.setScene(scene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}