package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArmeryController implements Initializable {
    @FXML
    public Label armeriaTitle;
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
    public ComboBox comboArmas;
    public ComboBox comboAtaque1;
    public ComboBox comboAtaque2;
    public ComboBox comboAtaque3;
    private static List<Weapon> listaW = new ArrayList<>(Weapon.generarArmasDesdeArchivo());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] valores=new String[6];
        for (int i = 0; i < listaW.size(); i++) {
            valores[i]= String.valueOf(listaW.get(i).getNombre());
        }
        comboArmas.getItems().addAll(valores);
        comboArmas.setValue(" ");
    }

    public void cancelar(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Floor.fxml")));
            Stage window= (Stage) armeriaTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Select Character");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarCambios(MouseEvent mouseEvent) {

    }

    public void addMana(MouseEvent mouseEvent) {

    }

    public void addMagia(MouseEvent mouseEvent) {
    }

    public void addVida(MouseEvent mouseEvent) {
    }

    public void addFuerza(MouseEvent mouseEvent) {
    }

    public void addDefensa(MouseEvent mouseEvent) {
    }
    //cambio los valores de los label segun el arma seleccionada
    public void comboArmasOA(ActionEvent actionEvent) {
        String selectedWeapon = comboArmas.getValue().toString();
        for (Weapon weapon : listaW) {
            if (weapon.getNombre().equals(selectedWeapon)) {
                labelFuerza.setText(String.valueOf(weapon.getFuerza()));
                labelDefensa.setText(String.valueOf(weapon.getDefensa()));
                labelVida.setText(String.valueOf(weapon.getVida()));
                labelMagia.setText(String.valueOf(weapon.getMagia()));
                labelMana.setText(String.valueOf(weapon.getMana()));
                break;
            }
        }
    }
}
