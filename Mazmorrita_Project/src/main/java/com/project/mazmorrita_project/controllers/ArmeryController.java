/*

 */
package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Attack;
import com.project.mazmorrita_project.models.Character;
import com.project.mazmorrita_project.models.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.project.mazmorrita_project.models.Character.showCharacters;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;

public class ArmeryController implements Initializable {

    @FXML
    public Label labelFuerzaArma;
    @FXML
    public Label labelDefensaArma;
    @FXML
    public Label labelVidaArma;
    @FXML
    public Label labelMagiaArma;
    @FXML
    public Label labelManaArma;
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

    private static List<Weapon> listaW = new ArrayList<>(Weapon.showWeapon(SelectCharacterController.nameSelected));
    private static List<Attack> listaA = new ArrayList<>(Attack.showAttacks(SelectCharacterController.nameSelected));



    private static String[] valores=new String[6];
    private List<String> attackValues = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i < listaA.size(); i++) {
            attackValues.add(String.valueOf(listaA.get(i).getNombre()));
        }
        comboAtaque1.getItems().addAll(attackValues);
        comboAtaque1.setValue(" ");

        comboAtaque2.getItems().addAll(attackValues);
        comboAtaque2.setValue(" ");

        comboAtaque3.getItems().addAll(attackValues);
        comboAtaque3.setValue(" ");


            for (int i = 0; i < listaW.size(); i++) {
            valores[i]= String.valueOf(listaW.get(i).getNombre());
        }
        comboArmas.getItems().addAll(valores);
        comboArmas.setValue(" ");

        List<Character> characters = showCharacters(SelectCharacterController.nameSelected, "Nombre");

        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);
            labelFuerza.setText(String.valueOf(character.getFuerza()));
            labelDefensa.setText(String.valueOf(character.getDefensa()));
            labelVida.setText(String.valueOf(character.getVida()));
            labelMagia.setText(String.valueOf(character.getMagia()));
            labelMana.setText(String.valueOf(character.getMana()));
        }
/*
        fuerzaOriginal = Integer.parseInt(labelFuerza.getText());
        defensaOriginal = Integer.parseInt(labelDefensa.getText());
        vidaOriginal = Integer.parseInt(labelVida.getText());
        magiaOriginal = Integer.parseInt(labelMagia.getText());
        manaOriginal = Integer.parseInt(labelMana.getText());
  */
    }


    public void guardarCambios(MouseEvent mouseEvent) {
        attackValues = new ArrayList<>();
        String[] listValues = new String[6];
        listValues[0] = labelFuerza.getText();
        listValues[1] = labelDefensa.getText();
        listValues[2] = labelVida.getText();
        listValues[3] = labelMagia.getText();
        listValues[4] = labelMana.getText();
        listValues[5] = SelectCharacterController.nameSelected;
        ExecuteChangesSql("UPDATE personajes SET Fuerza = ?, Defensa = ?, Vida = ?, Magia = ?, Mana = ? WHERE Nombre = ?", listValues);
        try {
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/com/project/mazmorrita_project/floor-view.fxml")));
            Stage window= (Stage) armeriaTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Floor");
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addMana(MouseEvent mouseEvent) {
        labelMana.setText(String.valueOf(Integer.parseInt(labelMana.getText()) + 1));
    }
    public void addMagia(MouseEvent mouseEvent) {
        labelMagia.setText(String.valueOf(Integer.parseInt(labelMagia.getText()) + 1));

    }
    public void addVida(MouseEvent mouseEvent) {
        labelVida.setText(String.valueOf(Integer.parseInt(labelVida.getText()) + 1));

    }
    public void addFuerza(MouseEvent mouseEvent) {
        labelFuerza.setText(String.valueOf(Integer.parseInt(labelFuerza.getText()) + 1));

    }
    public void addDefensa(MouseEvent mouseEvent) {
        labelDefensa.setText(String.valueOf(Integer.parseInt(labelDefensa.getText()) + 1));

    }

    //Cambia los valores de los label según el arma seleccionada y se los suma a los stacks de los pj
    public void comboArmasOA(ActionEvent actionEvent) {

        String selectedWeapon = comboArmas.getValue().toString();
        for (Weapon weapon : listaW) {
            if (weapon.getNombre().equals(selectedWeapon)) {
                // Restaurar los valores originales
                labelFuerzaArma.setText(String.valueOf(weapon.getFuerza()));
                labelDefensaArma.setText(String.valueOf(weapon.getDefensa()));
                labelVidaArma.setText(String.valueOf(weapon.getVida()));
                labelMagiaArma.setText(String.valueOf(weapon.getMagia()));
                labelManaArma.setText(String.valueOf(weapon.getMana()));


                /*
                int fuerzaConArma = fuerzaOriginal + weapon.getFuerza();
                labelFuerzaArma.setText(String.valueOf(fuerzaConArma));
                int defConArma = defensaOriginal + weapon.getDefensa();
                labelDefensaArma.setText(String.valueOf(defConArma));
                int vidaConArma = vidaOriginal + weapon.getVida();
                labelVidaArma.setText(String.valueOf(vidaConArma));
                int magiaConArma = magiaOriginal + weapon.getMagia();
                labelMagiaArma.setText(String.valueOf(magiaConArma));
                int manaConArma = manaOriginal + weapon.getMana();
                labelManaArma.setText(String.valueOf(manaConArma));
                break;
                 */
            }
        }
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
}
