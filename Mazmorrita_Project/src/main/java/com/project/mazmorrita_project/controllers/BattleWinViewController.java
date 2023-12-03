package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BattleWinViewController implements Initializable {

    @FXML
    public Label botinRecibido;

    public static int exp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botinRecibido.setText(String.valueOf(exp));
    }

    public void volver(MouseEvent mouseEvent) {
        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor-view.fxml")));
            Stage window = (Stage) botinRecibido.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Floor");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
