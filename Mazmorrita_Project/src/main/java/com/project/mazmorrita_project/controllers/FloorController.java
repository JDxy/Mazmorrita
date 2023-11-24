package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FloorController {
    @FXML
    public ImageView bossPisoUno;

    public void bicho1(MouseEvent mouseEvent) {
    }

    public void bicho2(MouseEvent mouseEvent) {
    }
    public void bicho3(MouseEvent mouseEvent) {
    }
    public void boss(MouseEvent mouseEvent) {
    }
    public void armeria(MouseEvent mouseEvent) {
    }
    public void salir(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Login.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
