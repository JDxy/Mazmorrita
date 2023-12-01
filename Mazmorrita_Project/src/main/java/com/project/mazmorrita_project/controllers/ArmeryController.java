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
import java.util.*;

import static com.project.mazmorrita_project.models.Character.showCharacters;
import static com.project.mazmorrita_project.models.Character.showStacksCharacters;

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
    private static int fuerzaOriginal;
    private static int defensaOriginal;
    private static int vidaOriginal;
    private static int magiaOriginal;
    private static int manaOriginal;

    private static List<Weapon> listaW = new ArrayList<>(Weapon.generarArmasDesdeArchivo());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] valores=new String[6];
        for (int i = 0; i < listaW.size(); i++) {
            valores[i]= String.valueOf(listaW.get(i).getNombre());
        }
        comboArmas.getItems().addAll(valores);
        comboArmas.setValue(" ");
        List<HashMap<String, String>> characters = showStacksCharacters(SelectCharacterController.nameSelected);
        Label[] vida={labelVida};
        Label[] fuerza={labelFuerza};
        Label[] defensa={labelDefensa};
        Label[] magia={labelMagia};
        Label[] mana={labelMana};

       // Label[] experiencia={labelExperiencia}; falta añadirlo en la vista x eso esta comendado
        for (int i = 0; i < characters.size(); i++) {
            HashMap<String, String> character = characters.get(i);
            for (Map.Entry<String, String> entry : character.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if ("Vida".equals(key)) {
                    vida[i].setText(value);
                } else if ("Fuerza".equals(key)) {
                    fuerza[i].setText(value);
                } else if ("Defensa".equals(key)) {
                    defensa[i].setText(value);
                }else if ("Magia".equals(key)) {
                    magia[i].setText(value);
                }else if ("Mana".equals(key)) {
                    mana[i].setText(value);
                }
                /*else if ("Experiencia".equals(key)) {
                    vida[i].setText(value);
                }*/
            }
        }
       fuerzaOriginal = Integer.parseInt(labelFuerza.getText());
       defensaOriginal = Integer.parseInt(labelDefensa.getText());
       vidaOriginal = Integer.parseInt(labelVida.getText());
       magiaOriginal = Integer.parseInt(labelMagia.getText());
       manaOriginal = Integer.parseInt(labelMana.getText());
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

    //Cambia los valores de los label según el arma seleccionada y se los suma a los stacks de los pj
    public void comboArmasOA(ActionEvent actionEvent) {
        String selectedWeapon = comboArmas.getValue().toString();
        for (Weapon weapon : listaW) {
            if (weapon.getNombre().equals(selectedWeapon)) {
                // Restaurar los valores originales
                int fuerzaConArma = fuerzaOriginal + weapon.getFuerza();
                labelFuerza.setText(String.valueOf(fuerzaConArma));
                int defConArma = defensaOriginal + weapon.getDefensa();
                labelDefensa.setText(String.valueOf(defConArma));
                int vidaConArma = vidaOriginal + weapon.getVida();
                labelVida.setText(String.valueOf(vidaConArma));
                int magiaConArma = magiaOriginal + weapon.getMagia();
                labelMagia.setText(String.valueOf(magiaConArma));
                int manaConArma = manaOriginal + weapon.getMana();
                labelMana.setText(String.valueOf(manaConArma));
                break;
            }
        }
    }
    public void volverAtras(MouseEvent mouseEvent) {
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/Floor.fxml")));
            Stage window= (Stage) armeriaTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
