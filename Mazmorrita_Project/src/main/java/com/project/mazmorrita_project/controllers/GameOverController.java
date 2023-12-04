package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Attack;
import com.project.mazmorrita_project.models.Character;
import com.project.mazmorrita_project.models.Weapon;
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

import static com.project.mazmorrita_project.models.Character.deleteCharacter;

public class GameOverController implements Initializable {
    @FXML
    public Label gameOverTitle;
    public void nuevaPartida(MouseEvent mouseEvent) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/selectcharacter-view.fxml")));
            Stage window = (Stage) gameOverTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void salir(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/main-view.fxml")));
            Stage window= (Stage) gameOverTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Attack.deleteAttacksTable(Character.character.getNombre(), LoginController.id);
        Weapon.deleteWeaponTable(Character.character.getNombre(), LoginController.id);
        deleteCharacter(Character.character.getNombre(), LoginController.id);

        CombatController.armaSeleccionada= null;
        CombatController.ataquesSeleccionados= null;
        CombatController.numEnemigo= 0;

        FloorController.enemigosDerrotados= null;


    }
}
