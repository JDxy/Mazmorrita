package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.*;
import com.project.mazmorrita_project.models.Character;
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

import static com.project.mazmorrita_project.models.Character.showCharacters;
import static com.project.mazmorrita_project.models.LocalConnection.ExecuteChangesSql;

public class ArmeryControler implements Initializable {
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
    public Label labelFuerzaFinal;
    public Label labelDefensaFinal;
    public Label labelVidaFinal;
    public Label labelMagiaFinal;
    public Label labelManaFinal;
    private static int fuerzaOriginal;
    private static int defensaOriginal;
    private static int vidaOriginal;
    private static int magiaOriginal;
    private static int manaOriginal;
    final private static ArrayList<AttackPj> listaAPJ = new ArrayList<>(AttackPj.mostrarAtaquesPersonajes(SelectCharacterController.nameSelected, LoginController.id));
    final private static ArrayList<Weapon> listaW = new ArrayList<>(Weapon.showWeapon(SelectCharacterController.nameSelected, LoginController.id));
    private ArrayList<String> weaponValues = new ArrayList<>();
    public static ArrayList<Weapon> weaponsList = new ArrayList<>();
    private List<String> attackValues = new ArrayList<>();
    private Character character = SelectCharacterController.characterSelected;

    //atributo para pasar el nombre de las armas seleccionadas.
    public static String[] ataquesSeleccionadas =new String[3];
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i < listaW.size(); i++) {
            weaponValues.add(String.valueOf(listaW.get(i).getNombre()));
        }

        character.setArmas(listaW);
        comboArmas.getItems().addAll(weaponValues);
        comboArmas.setValue(" ");

        for (int i = 0; i < listaAPJ.size(); i++) {
            attackValues.add(String.valueOf(listaAPJ.get(i).getNombre()));
        }
        comboAtaque1.getItems().addAll(attackValues);
        comboAtaque1.setValue(" ");
        comboAtaque2.getItems().addAll(attackValues);
        comboAtaque2.setValue(" ");
        comboAtaque3.getItems().addAll(attackValues);
        comboAtaque3.setValue(" ");

        //Cogemos los valores del personaje seleccionado
        fuerzaOriginal= Character.character.getFuerza();
        defensaOriginal=  Character.character.getDefensa();
        vidaOriginal=  Character.character.getVida();
        magiaOriginal= Character.character.getMagia();
        manaOriginal=  Character.character.getMana();
        //Asignamos los valores del personaje seleccionado a los label correlativos
        labelFuerza.setText(String.valueOf(fuerzaOriginal));
        labelDefensa.setText(String.valueOf(defensaOriginal));
        labelVida.setText(String.valueOf(vidaOriginal));
        labelMagia.setText(String.valueOf(magiaOriginal));
        labelMana.setText(String.valueOf(manaOriginal));
        //Se suman a los valores los puntos del arma seleccionada.
        labelFuerzaFinal.setText(String.valueOf(fuerzaOriginal));
        labelDefensaFinal.setText(String.valueOf(defensaOriginal));
        labelVidaFinal.setText(String.valueOf(vidaOriginal));
        labelMagiaFinal.setText(String.valueOf(magiaOriginal));
        labelManaFinal.setText(String.valueOf(manaOriginal));
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
            //guardamos los valores nombres de los ataques seleccionados en el arreglo de string para pasarlo al combate.
            ataquesSeleccionadas[0]= (String) comboAtaque1.getValue();
            ataquesSeleccionadas[1]= (String) comboAtaque2.getValue();
            ataquesSeleccionadas[2]= (String) comboAtaque3.getValue();

            CombatController.ataquesSeleccionados = ataquesSeleccionadas;

            CombatController.armaSeleccionada = comboArmas.getValue().toString();

            String[] listValues = new String[6];
            listValues[0] = labelFuerza.getText();
            listValues[1] = labelDefensa.getText();
            listValues[2] = labelVida.getText();
            listValues[3] = labelMagia.getText();
            listValues[4] = labelMana.getText();
            listValues[5] = SelectCharacterController.nameSelected;
            ExecuteChangesSql("UPDATE personajes SET Fuerza = ?, Defensa = ?, Vida = ?, Magia = ?, Mana = ? WHERE Nombre = ?", listValues);

            List<Character> characters = showCharacters(SelectCharacterController.nameSelected, "Nombre");

            character = characters.get(0);
            character.setFuerza(Integer.parseInt(labelFuerza.getText()));
            character.setDefensa(Integer.parseInt(labelDefensa.getText()));
            character.setVida(Integer.parseInt(labelVida.getText()));
            character.setMagia(Integer.parseInt(labelMagia.getText()));
            character.setMana(Integer.parseInt(labelMana.getText()));

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
        String selectedWeapon = comboArmas.getValue().toString();
        for (Weapon weapon : listaW) {
            if (weapon.getNombre().equals(selectedWeapon)) {
                // Restaurar los valores originales
                labelFuerzaArma.setText(String.valueOf(weapon.getFuerza()));
                labelDefensaArma.setText(String.valueOf(weapon.getDefensa()));
                labelVidaArma.setText(String.valueOf(weapon.getVida()));
                labelMagiaArma.setText(String.valueOf(weapon.getMagia()));
                labelManaArma.setText(String.valueOf(weapon.getMana()));

                labelFuerzaFinal.setText(String.valueOf(Integer.parseInt(labelFuerzaFinal.getText()) + weapon.getFuerza()));
                labelDefensaFinal.setText(String.valueOf(Integer.parseInt(labelDefensaFinal.getText()) + weapon.getDefensa()));
                labelVidaFinal.setText(String.valueOf(Integer.parseInt(labelVidaFinal.getText()) + weapon.getVida()));
                labelMagiaFinal.setText(String.valueOf(Integer.parseInt(labelMagiaFinal.getText()) + weapon.getMagia()));
                labelManaFinal.setText(String.valueOf(Integer.parseInt(labelManaFinal.getText()) + weapon.getMana()));

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


}
