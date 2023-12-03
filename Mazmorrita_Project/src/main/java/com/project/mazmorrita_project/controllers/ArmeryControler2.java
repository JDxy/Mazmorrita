package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Alert;
import com.project.mazmorrita_project.models.Attack;
import com.project.mazmorrita_project.models.AttackPj;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArmeryControler2 implements Initializable {
    public Label armeriaTitle;
    public ComboBox comboArmas;
    public ComboBox comboAtaque1;
    public ComboBox comboAtaque2;
    public ComboBox comboAtaque3;
    public Label labelFuerza;
    public Label labelDefensa;
    public Label labelVida;
    public Label labelMagia;
    public Label labelMana;
    public Label labelFuerzaArma;
    public Label labelDefensaArma;
    public Label labelVidaArma;
    public Label labelMagiaArma;
    public Label labelManaArma;
    public Label labelFuerza11;
    public Label labelDefensa11;
    public Label labelVida11;
    public Label labelMagia11;
    public Label labelMana11;
    private static int fuerzaOriginal;
    private static int defensaOriginal;
    private static int vidaOriginal;
    private static int magiaOriginal;
    private static int manaOriginal;
    final private static List<AttackPj> listaAPJ = new ArrayList<>(AttackPj.mostrarAtaquesPersonajes(SelectCharacterController.nameSelected, LoginController.id));
    private List<String> attackValues = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i < listaAPJ.size(); i++) {
            attackValues.add(String.valueOf(listaAPJ.get(i).getNombre()));
        }
        comboAtaque1.getItems().addAll(attackValues);
        comboAtaque1.setValue(" ");

        comboAtaque2.getItems().addAll(attackValues);
        comboAtaque2.setValue(" ");

        comboAtaque3.getItems().addAll(attackValues);
        comboAtaque3.setValue(" ");


    }
    public void volverAtras(MouseEvent mouseEvent) {
        try {
            attackValues = new ArrayList<>();
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor-view.fxml")));
            Stage window= (Stage) armeriaTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarCambios(MouseEvent mouseEvent) {

        if(comboAtaque1.getValue().equals(comboAtaque2.getValue()) || comboAtaque1.getValue().equals(comboAtaque3.getValue()) ){
            Alert.showAlert("Error","Debe seleccionar diferentes ataques para equiparse", javafx.scene.control.Alert.AlertType.ERROR);
        }else if(comboAtaque2.getValue().equals(comboAtaque1.getValue()) || comboAtaque2.getValue().equals(comboAtaque3.getValue()) ){
            Alert.showAlert("Error","Debe seleccionar diferentes ataques para equiparse", javafx.scene.control.Alert.AlertType.ERROR);
        } else if(comboAtaque3.getValue().equals(comboAtaque1.getValue()) || comboAtaque3.getValue().equals(comboAtaque2.getValue()) ){
            Alert.showAlert("Error","Debe seleccionar diferentes ataques para equiparse", javafx.scene.control.Alert.AlertType.ERROR);
        } else {

            //Guardar cosas

            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor-view.fxml")));
                Stage window = (Stage) armeriaTitle.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("Floor");
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void comboArmasOA(ActionEvent actionEvent) {
    }

    public void addFuerza(MouseEvent mouseEvent) {
    }

    public void addDefensa(MouseEvent mouseEvent) {
    }

    public void addVida(MouseEvent mouseEvent) {
    }

    public void addMagia(MouseEvent mouseEvent) {
    }

    public void addMana(MouseEvent mouseEvent) {
    }


}
