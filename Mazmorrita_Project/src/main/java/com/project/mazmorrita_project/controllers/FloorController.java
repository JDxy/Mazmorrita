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
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Combat.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void bicho2(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Combat.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void bicho3(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Combat.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void boss(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Combat.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void armeria(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Armery.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Armery");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
