package com.project.mazmorrita_project.controllers;

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

import static com.project.mazmorrita_project.models.Character.deleteCharacter;
import static com.project.mazmorrita_project.models.Character.showCharacters;

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
    private String nameSelected = null;
    public static Image imageSelected = null;

    public void initialize() {
        List<HashMap<String, String>> characters = showCharacters(SignInController.id);

        Pane[] panels = {Panel1, Panel2, Panel3, Panel4, Panel5};
        ImageView[] imageViews = {ImageView1, ImageView2, ImageView3, ImageView4, ImageView5};
        Label[] names = {Name1, Name2, Name3, Name4, Name5};
        Label[] experiences = {Experience1, Experience2, Experience3, Experience4, Experience5};

        for (int i = 0; i < characters.size(); i++) {
            panels[i].setVisible(true);
            HashMap<String, String> character = characters.get(i);

            for (Map.Entry<String, String> entry : character.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if ("Avatar".equals(key)) {
                    Image image = new Image("file:" + value);
                    imageViews[i].setImage(image);

                } else if ("Nombre".equals(key)) {
                    names[i].setText(value);
                } else if ("Experiencia".equals(key)) {
                    experiences[i].setText(value);
                }
            }
        }
    }

    public void crearPersonaje(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/CreateCharacter.fxml")));
            Stage window= (Stage) seleccionPersonajeTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("CreateCharacter");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Login.fxml")));
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
            scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/SelectCharacter.fxml")));
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
            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Floor.fxml")));
                Stage window = (Stage) seleccionPersonajeTitle.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("floor");
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
