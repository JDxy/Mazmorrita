package com.project.mazmorrita_project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.events.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateCharacterController {
    @FXML
    public Label crearPersonajeTitle;
    @FXML
    public TextField tFNombre;
    @FXML
    public Label labelDefensa;
    @FXML
    public Label labelFuerza;
    @FXML
    public Label labelVida;
    @FXML
    public Label labelMagia;
    @FXML
    public Label labelMana;

    public void cancelar(MouseEvent mouseEvent) {
        // TODO
    }

    public void crearPersonaje(MouseEvent mouseEvent) {
    }
}
