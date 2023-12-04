package com.project.mazmorrita_project.models;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Java Class meant to control Enemies in "Proyecto-Mazmorrita"
 * @author Leonardo Jesús Figueroa Valdivia
 * @since 25-11-2023
 */
public class Enemy {
    private String avatar;
    private String nombre;
    private int vidaMaxima;
    private int vidaActual;
    private int fuerza;
    private int defensaBase;
    private int defensa;
    private ArrayList<Attack> ataques;
    private int botin;
    private boolean jefe;

    public Enemy(int idPiso, boolean isJefe) {
        String sqlSentence= "SELECT Nombre, Avatar, Vida, Fuerza, Defensa, Jefe, Botin FROM Enemigos where IdPiso= ? AND Jefe= ?";
        String[] values= {""+idPiso, ""+((isJefe)? 1:0)};

        List<HashMap<String, String>> allEnemies= LocalConnection.ExecuteSelectSql(sqlSentence, values);
        HashMap<String, String> singleEnemy= allEnemies.get((int)(Math.random()*allEnemies.size()));

        nombre= singleEnemy.get("Nombre");
        avatar= singleEnemy.get("Avatar");
        vidaMaxima= Integer.parseInt(singleEnemy.get("Vida"));
        vidaActual= vidaMaxima;
        fuerza= Integer.parseInt(singleEnemy.get("Fuerza"));
        defensaBase= Integer.parseInt(singleEnemy.get("Defensa"));
        defensa= defensaBase;
        jefe= !singleEnemy.get("Jefe").equals("0");
        botin= Integer.parseInt(singleEnemy.get("Botin"));
        ataques= conseguirAtaques(nombre);
    }

    public ArrayList<Attack> conseguirAtaques(String nombre) {
        String sqlSentence= "SELECT Nombre, Potencia, Tipo FROM Ataques WHERE Nombre IN (SELECT NombreAtaque FROM Ataque_enemigo WHERE NombreEnemigo= ?);";
        String[] values= {nombre};
        ArrayList<Attack> ataques2= new ArrayList<>();
        List<HashMap<String, String>> allAtacks= LocalConnection.ExecuteSelectSql(sqlSentence, values);
        for (HashMap<String, String> ataque : allAtacks) {
            ataques2.add(new Attack(ataque.get("Nombre"), Integer.parseInt(ataque.get("Potencia")), ataque.get("Tipo")));
        }
        return ataques2;
    }

    public String getAvatar() {
        return avatar;
    }
    public String getNombre() {
        return nombre;
    }
    public int getVidaMaxima() {
        return vidaMaxima;
    }
    public int getVidaActual() {
        return vidaActual;
    }
    public int getFuerza() {
        return fuerza;
    }
    public int getDefensa() {
        return defensa;
    }
    public ArrayList<Attack> getAtaques() {
        return ataques;
    }
    public boolean isJefe() {
        return jefe;
    }

    /**
     * Metodo que resta la vida del enemigo una cantidad de daño
     * @param damage (int) Daño que recive el enemigo
     * @return (boolean) True si sobrevive el ataque, False si muere
     */
    public boolean restarVida(int damage){
        // (vidaActual-(AtaqueEnemigo*(MultiplicadorAtque/100)*Defenza)
        // 500 - (200 / (500*0.5))
        vidaActual= (vidaActual-damage);
        return vidaActual <= 0;
    }

    /**
     * Metodo que devuelve el Botin de un enemigo cuando lo matas
     * @return El botin del enemigo
     */
    public int devolverBotin() {
        return botin;
    }

    /**
     * Metodo que ataque que realiza el enemigo
     * @return (HashMap&lt;String, Integer&gt;) Daño puro que realiza un enemigo antes de ser reducido por la defenza
     */
    public HashMap<String, Integer> atacar(){
        HashMap<String, Integer> ataqueMap= new HashMap<>();
        Attack ataque= ataques.get((int) (Math.random() * ataques.size()));
        ataqueMap.put(ataque.getNombre(), (fuerza*(ataque.getPotencia()/100)));
        return ataqueMap;
    }

    /**
     * Metodo que aumenta la defensa durante el tiempo que se especifique
     * @param action (String) "Defender" si se empieza a defender, "Dejar" si se deja de defender
     */
    public void defenderse(String action){
        switch (action){
            case "Defender":
                defensa= (int) (defensaBase+(vidaMaxima*0.5));
                break;
            case "Dejar":
                defensa= defensaBase;
                break;
        }
    }
}
