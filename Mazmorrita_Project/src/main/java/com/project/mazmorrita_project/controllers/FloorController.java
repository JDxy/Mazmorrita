package com.project.mazmorrita_project.controllers;
import com.project.mazmorrita_project.models.Alert;
import com.project.mazmorrita_project.models.Floor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class FloorController {
    @FXML
    public ImageView bossPisoUno;

    @FXML
    public ImageView enemyAvatar1;

    @FXML
    public ImageView enemyAvatar2;

    @FXML
    public ImageView enemyAvatar3;

    @FXML
    public ImageView personajeAvatar;

    public static Image imageAvatar = null;

    public static TreeSet<Integer> enemigosDerrotados= new TreeSet<>();

    public void initialize() {
        if (SelectCharacterController.imageSelected != null){
            imageAvatar = SelectCharacterController.imageSelected;
            SelectCharacterController.imageSelected = null;
        }
        
        if (CreateCharacterController.imageSelected != null){ 
            imageAvatar = CreateCharacterController.imageSelected;
            CreateCharacterController.imageSelected = null;
        }
        personajeAvatar.setImage(imageAvatar);

        bossPisoUno.setDisable(true);

        showEnemy(enemyAvatar1);
        showEnemy(enemyAvatar2);
        showEnemy(enemyAvatar3);


        for (int i: enemigosDerrotados){
            switch (i){
                case 1:
                    enemyAvatar1.setDisable(true);
                    break;
                case 2:
                    enemyAvatar2.setDisable(true);
                    break;
                case 3:
                    enemyAvatar3.setDisable(true);
                    break;
            }
        }

        if (enemigosDerrotados.size() == Floor.floor.getNumEnemigos()){
            bossPisoUno.setDisable(false);
        }
    }
    public void showEnemy(ImageView enemyAvatar){
       /* Enemy enemy = new Enemy(1, false);
        Image image = new Image("file:" + enemy.getAvatar());
        enemyAvatar.setImage(image);
        */
    }
    public void bicho1(MouseEvent mouseEvent) {
        if(CombatController.ataquesSeleccionados==null){
            Alert.showAlert("Error", "Debe equiparse en armeria", javafx.scene.control.Alert.AlertType.ERROR);
        }else {
            try {
                CombatController.setEnemy(Floor.floor.getEnemigos().get(0));
                CombatController.numEnemigo = 1;

                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/combat-view.fxml")));
                Stage window = (Stage) bossPisoUno.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("floor");
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void bicho2(MouseEvent mouseEvent) {
        if(CombatController.ataquesSeleccionados==null){
            Alert.showAlert("Error", "Debe equiparse en armeria", javafx.scene.control.Alert.AlertType.ERROR);
        }else {
            try {
                CombatController.setEnemy(Floor.floor.getEnemigos().get(1));
                CombatController.numEnemigo = 2;

                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/combat-view.fxml")));
                Stage window = (Stage) bossPisoUno.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("floor");
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void bicho3(MouseEvent mouseEvent) {
        if(CombatController.ataquesSeleccionados==null){
            Alert.showAlert("Error", "Debe equiparse en armeria", javafx.scene.control.Alert.AlertType.ERROR);
        }else {
            try {
                CombatController.setEnemy(Floor.floor.getEnemigos().get(2));
                CombatController.numEnemigo = 3;

                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/combat-view.fxml")));
                Stage window = (Stage) bossPisoUno.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("floor");
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void boss(MouseEvent mouseEvent) {
        if(CombatController.ataquesSeleccionados==null){
            Alert.showAlert("Error", "Debe equiparse en armeria", javafx.scene.control.Alert.AlertType.ERROR);
        }else {
            try {
                CombatController.setEnemy(Floor.floor.getJefe());

                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/combat-view.fxml")));
                Stage window = (Stage) bossPisoUno.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("floor");
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void armeria(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/armery-view.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Armery");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void salir(MouseEvent mouseEvent) {
        try {
            SelectCharacterController.nameSelected = null;
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/main-view.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void volverAtras(MouseEvent mouseEvent) {
        try {
            SelectCharacterController.nameSelected = null;
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/selectcharacter-view.fxml")));
            Stage window= (Stage) bossPisoUno.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Select Character");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
