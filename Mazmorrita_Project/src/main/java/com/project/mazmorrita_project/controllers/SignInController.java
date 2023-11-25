package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static com.project.mazmorrita_project.models.SingInModel.findUser;

public class SignInController {
    @FXML
    public Label iniciarSesionTitle;
    @FXML
    public TextField tFNombre;
    @FXML
    public PasswordField tFPassword;

    public void iniciarSesion(MouseEvent mouseEvent) {
        if (findUser(tFNombre.getText(), tFPassword.getText())){
            System.out.println("encontrao");
            Scene scene= null;
            try {
                scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/SelectCharacter.fxml")));
                Stage window= (Stage) iniciarSesionTitle.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("SelectCharacter");
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {
            System.out.println("false");
            Alert.showAlert("Error", "Nombre o contraseña no validos.", javafx.scene.control.Alert.AlertType.ERROR); }
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
