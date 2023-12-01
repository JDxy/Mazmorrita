package com.project.mazmorrita_project.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Java Class meant to control the floors of a dungeon in "Proyecto-Mazmorrita"
 * @author Leonardo Jesús Figueroa Valdivia
 * @since 25-11-2023
 */
public class Floor {

    private int id;
    private int numero;
    private int numEnemigos;
    private ArrayList<Enemy> enemigos;
    private Enemy jefe;
    private String imagen;

    public Floor(int idPiso) {
        actualizarPiso(idPiso);
    }

    /**
     * Metodo para cambiar de piso
     * @param numPiso (Int) Número de piso actual
     */
    public void cambiarPiso(int numPiso){
        actualizarPiso(numPiso);
    }

    private void actualizarPiso(int id){
        String sqlSentence= "SELECT Pisos.Id, Pisos.Numero, Pisos.NumeroEnemigos, Pisos.ImagenPiso FROM Pisos where Pisos.Id= ?;";
        String[] values= {""+id};
        List<HashMap<String, String>> results= LocalConnection.ExecuteSelectSql(sqlSentence, values);

        HashMap<String, String> piso= results.get( (int)(Math.random()*results.size()));

        this.id= Integer.parseInt(piso.get("1"));
        numero= Integer.parseInt(piso.get("2"));
        numEnemigos= Integer.parseInt(piso.get("3"));
        imagen= piso.get("4");
        enemigos= new ArrayList<>();

        for (int i = 0; i < numEnemigos; i++) {
            enemigos.add(new Enemy(id, false));
        }

        jefe= new Enemy(id, true);
    }

    /**
     * Devuelve todos los enemigos del piso
     * @return (ArrayList&lt;Enemy&gt;) ArrayList con todos los enemigos de la planta
     */
    public ArrayList<Enemy> getAllEnemies(){
        return enemigos;
    }

    /**
     * Devuelve el enemigo concreto
     * @param pos (Int) Posicion de la array en la que se encuentra el enemigo
     * @return (Enemy) El enemigo concreto que se encuentra en la posicion proporcionada
     */
    public Enemy getEnemyByPos(int pos){
        return enemigos.get(pos);
    }

    public Enemy getJefe(){
        return jefe;
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public int getNumEnemigos() {
        return numEnemigos;
    }

    public String getImagen() {
        return imagen;
    }
}
