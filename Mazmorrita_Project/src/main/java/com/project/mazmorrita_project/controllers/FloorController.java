package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.LocalConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FloorController {
    @FXML
    public ImageView bossPisoUno;

    @FXML
    public ImageView personajeAvatar;

    public static Image imageAvatar = null;



    public void initialize() {
        if (SelectCharacterController.imageSelected != null){
            imageAvatar = SelectCharacterController.imageSelected;
            SelectCharacterController.imageSelected = null;
        }
        
        if (CreateCharacterController.imageSelected != null){ 
            imageAvatar = CreateCharacterController.imageSelected;
            CreateCharacterController.imageSelected = null;
        }
        personajeAvatar.setImage(imageAvatar);

    }
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
