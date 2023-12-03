package com.project.mazmorrita_project.controllers;

import com.project.mazmorrita_project.models.Attack;
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
import javafx.scene.layout.Pane;
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
    @FXML
    public Pane volverAtrasPane;


    private Character character;
    private static Enemy enemy;
    private String[] turnos;
    public static int numEnemigo;

    public void initialize(){
        character = Character.character;

        Image pjAvatar = new Image("file:" + character.getAvatar());
        imagePJ.setImage(pjAvatar);

        Image enemyAvatar= new Image("file:"+enemy.getAvatar());
        imageEnemy.setImage(enemyAvatar);

        vidaEnemy.setText(String.valueOf(enemy.getVidaMaxima()));
        vidaMaxPJ.setText(String.valueOf(character.getVidaMax()));
        vidaActualPj.setText(String.valueOf(character.getVida()));

        manaMaxPJ.setText(String.valueOf(character.getManaMax()));
        manaActualPj.setText(String.valueOf(character.getMana()));

        if ((Math.random()*20)%2 == 0){
            turnos= new String[]{"character", "enemy"};
        } else {
            turnos= new String[]{"enemy", "character"};
        }
    }

    public static void setEnemy(Enemy enemy) {
        CombatController.enemy = enemy;
    }

    public void salir(MouseEvent mouseEvent) {
        cambiarScene("/com/project/mazmorrita_project/floor-view.fxml", "Floor");
    }

    public void luchar(MouseEvent mouseEvent) {
        volverAtrasPane.setDisable(true);
        for (String turn : turnos) {
            if (turn.equals("character")){
                if (turnCharacter(attackPj.getValue().toString())){
                    BattleWinViewController.exp= enemy.devolverBotin();
                    FloorController.enemigosDerrotados.add(numEnemigo);

                    cambiarScene("/com/project/mazmorrita_project/battleWin-view.fxml", "Victory!!!");
                }
            }
            else {
                if (turnEnemyAttack()){
                    cambiarScene("/com/project/mazmorrita_project/gameover-view.fxml", "Game Over");
                }
            }
        }
    }

    private boolean turnEnemyAttack(){
        Attack attack= enemy.getAtaques().get((int) (Math.random()*enemy.getAtaques().size()));

        int damage= (int) ((enemy.getFuerza()) * (attack.getPotencia()) * (1/ character.getDefensa()) *0.5);

        actionsTextArea.setText(actionsTextArea.getText()+
                "\n"+enemy.getNombre()+" uso "+attack.getNombre()+" hizo: "+damage+" puntos de daño.");

        vidaActualPj.setText(String.valueOf(character.getVida()));

        return character.restarVida(damage);
    }

    private boolean turnCharacter(String attackName){
        Attack ataque= null;

        for (Attack attack : character.getAtaques()) {
            if (attack.getNombre().equals(attackName)){
                ataque= attack;
            }
        }

        if (ataque.getTipo().equals("Magico") && (ataque.getPotencia()*0.25) < character.getMana()){
            actionsTextArea.setText(actionsTextArea.getText()+
                    "\nNo tienes mana suficiente.");
            return false;
        }


        int damage= (int) ((character.getFuerza()) * (ataque.getPotencia())* (1/ enemy.getDefensa()) *0.5);

        if (ataque.getTipo().equals("Magico")){
            int manaActual= character.getMana();
            manaActual-= (int) (ataque.getPotencia()*0.25);

            character.setMana(manaActual);
            manaActualPj.setText(String.valueOf(character.getMana()));
        }

        actionsTextArea.setText(actionsTextArea.getText()+
                "\nHaz usado "+attackName+", hizite: "+damage+" puntos de daño.");

        vidaEnemy.setText(String.valueOf(enemy.getVidaActual()));

        return enemy.restarVida(damage);
    }

    private void cambiarScene(String ruta, String tittle){
        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource(ruta)));
            Stage window = (Stage) combatTitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle(tittle);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
