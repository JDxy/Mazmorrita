package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Alert;
import com.project.mazmorrita_project.models.RegisterModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    public Label registroTitle;
    @FXML
    public PasswordField tFPassword;
    @FXML
    public TextField tFNombre;

    public void confirmar(MouseEvent mouseEvent) {
        String nombre= tFNombre.getText();
        String password= tFPassword.getText();
        if(nombre.isEmpty() || password.isEmpty()){
            Alert.showAlert("Error", "Nombre o contraseña no validos.", javafx.scene.control.Alert.AlertType.ERROR);
        }else{
            RegisterModel.crearUsuario(nombre,password);
            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/SignIn.fxml")));
                Stage window= (Stage) registroTitle.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("SignIn");
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void cancelar(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Login.fxml")));
            Stage window= (Stage) registroTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
