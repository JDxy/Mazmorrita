package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Character;
import com.project.mazmorrita_project.models.Enemy;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CombatController {
    @FXML
    public Label combatTitle;
    @FXML
    public ImageView imagePJ;
    @FXML
    public ImageView imageEnemy;
    @FXML
    public ComboBox attackPj;
    @FXML
    public Label vidaActualPj;
    @FXML
    public Label manaActualPj;
    @FXML
    public Label manaMaxPJ;
    @FXML
    public Label vidaMaxPJ;
    @FXML
    public TextArea actionsTextArea;
    @FXML
    public Label vidaEnemy;


    private Character character;
    private static Enemy enemy;

    public void initialize(){
        character= Character.character;

        Image pjAvatar = new Image("file:" + character.getAvatar());
        imagePJ.setImage(pjAvatar);

        Image enemyAvatar= new Image("file:"+enemy.getAvatar());
        imageEnemy.setImage(enemyAvatar);

        vidaEnemy.setText(String.valueOf(enemy.getVidaMaxima()));


    }

    public static void setEnemy(Enemy enemy) {
        CombatController.enemy = enemy;
    }

    public void salir(MouseEvent mouseEvent) {
        try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor-view.fxml")));
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
