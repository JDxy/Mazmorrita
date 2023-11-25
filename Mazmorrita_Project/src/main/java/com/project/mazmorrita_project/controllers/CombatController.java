package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CombatController {
    @FXML
    public Label combatTitle;
    @FXML
    public ComboBox elegirAtaque;

    public void salir(MouseEvent mouseEvent) {
        try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor.fxml")));
        Stage window = (Stage) combatTitle.getScene().getWindow();
        window.setScene(scene);
        window.setTitle("floor");
        window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void luchar(MouseEvent mouseEvent) {
    }
}
