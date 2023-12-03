package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Alert;
import com.project.mazmorrita_project.models.Character;
import com.project.mazmorrita_project.models.Floor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.mazmorrita_project.models.Character.*;

public class SelectCharacterController {
    @FXML
    public Label seleccionPersonajeTitle;
    @FXML
    public Pane Panel1, Panel2, Panel3, Panel4, Panel5;
    @FXML
    public ImageView ImageView1, ImageView2, ImageView3, ImageView4, ImageView5;
    @FXML
    public Label Name1, Name2, Name3, Name4, Name5;
    @FXML
    public Label Experience1, Experience2, Experience3, Experience4, Experience5;
    private Pane panelSeleccionado = null;
    public static String nameSelected;
    public static Image imageSelected = null;
    public static Character characterSelected;

    public void initialize() {
        List<Character> characters = showCharacters(LoginController.id, "IdUsuario");
        Pane[] panels = {Panel1, Panel2, Panel3, Panel4, Panel5};
        ImageView[] imageViews = {ImageView1, ImageView2, ImageView3, ImageView4, ImageView5};
        Label[] names = {Name1, Name2, Name3, Name4, Name5};
        Label[] experiences = {Experience1, Experience2, Experience3, Experience4, Experience5};

        for (int i = 0; i < characters.size(); i++) {
            panels[i].setVisible(true);
            Character character = characters.get(i);

            Image image = new Image("file:" + character.getAvatar());
            imageViews[i].setImage(image);
            names[i].setText(character.getNombre());

            experiences[i].setText(String.valueOf(character.getExperiencia()));
        }
    }

    public void crearPersonaje(MouseEvent mouseEvent) {
        if (noMoreThan5(Integer.parseInt(LoginController.id))) {
            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/createcharacter-view.fxml")));
                Stage window = (Stage) seleccionPersonajeTitle.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("CreateCharacter");
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
        Alert.showAlert("Error", "Un usuario no puede tener mas de 5 personajes", javafx.scene.control.Alert.AlertType.ERROR);
    }
    }

    public void panelClick1(MouseEvent mouseEvent){
        nameSelected = Name1.getText();
        imageSelected = ImageView1.getImage();

        manejarSeleccion(Panel1);
    }

    public void panelClick2(MouseEvent mouseEvent){
        nameSelected = Name2.getText();
        imageSelected = ImageView2.getImage();

        manejarSeleccion(Panel2);
    }

    public void panelClick3(MouseEvent mouseEvent){
        nameSelected = Name3.getText();
        imageSelected = ImageView3.getImage();

        manejarSeleccion(Panel3);
    }

    public void panelClick4(MouseEvent mouseEvent){
        nameSelected = Name4.getText();
        imageSelected = ImageView4.getImage();

        manejarSeleccion(Panel4);
    }

    public void panelClick5(MouseEvent mouseEvent){
        nameSelected = Name5.getText();
        imageSelected = ImageView5.getImage();

        manejarSeleccion(Panel5);
    }

    private void manejarSeleccion(Pane panel){

        if(panelSeleccionado != null && panelSeleccionado != panel){
            quitarSeleccion(panelSeleccionado);
        }

        if(panel.equals(panelSeleccionado)){
            quitarSeleccion(panel);
            panelSeleccionado = null;
        } else {
            aplicarSeleccion(panel);
            panelSeleccionado = panel;
        }
    }

    private void aplicarSeleccion(Pane panel){
        BorderStroke bordeRojo = new BorderStroke(
                Color.RED,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderStroke.THIN
        );

        Border nuevoBorde = new Border(bordeRojo);
        panel.setBorder(nuevoBorde);
    }

    private void quitarSeleccion(Pane panel){
        panel.setBorder(null);
    }

    public void atras(MouseEvent mouseEvent) {
        try {
            nameSelected = null;
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/main-view.fxml")));
            Stage window= (Stage) seleccionPersonajeTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Login");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrarPersonaje(MouseEvent mouseEvent) {
        deleteCharacter(nameSelected);
        Scene scene= null;
        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/selectcharacter-view.fxml")));
            Stage window= (Stage) seleccionPersonajeTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("SelectCharacter");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void usarPersonaje(MouseEvent mouseEvent) {

        if (nameSelected != null) {
            System.out.println(nameSelected);
            characterSelected = showCharacters(nameSelected, "Nombre").get(0);
            character= characterSelected;
            Floor.floor= new Floor(character.getPiso());

            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor-view.fxml")));
                Stage window = (Stage) seleccionPersonajeTitle.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("floor");
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Alert.showAlert("ERROR","¡Para jugar debes de seleccionar un personaje!", javafx.scene.control.Alert.AlertType.ERROR);
        }
    }
}
