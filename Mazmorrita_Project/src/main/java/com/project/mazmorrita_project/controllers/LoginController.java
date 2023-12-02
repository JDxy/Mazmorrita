package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Alert;
import com.project.mazmorrita_project.models.LocalConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static com.project.mazmorrita_project.models.LoginModel.findUser;

public class LoginController {
    @FXML
    public Label iniciarSesionTitle;
    @FXML
    public TextField tFNombre;
    @FXML
    public PasswordField tFPassword;

    public static String id;
    public static List<HashMap<String,String>>list;
    public HashMap<String,String>idList;

    public void iniciarSesion(MouseEvent mouseEvent) {
        if (findUser(tFNombre.getText(), tFPassword.getText())){
            String[]values=new String[1];
            values[0]=tFNombre.getText();
            list= LocalConnection.ExecuteSelectSql("Select Id from usuarios where Nombre= ?",values);
            idList=list.get(0);
            id=idList.get("Id");

            Scene scene= null;
            try {
                scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/selectcharacter-view.fxml")));
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
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/main-view.fxml")));
            Stage window= (Stage) iniciarSesionTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
