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

    public static Floor floor;
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

        id= Integer.parseInt(piso.get("Id"));
        numero= Integer.parseInt(piso.get("Numero"));
        numEnemigos= Integer.parseInt(piso.get("NumeroEnemigos"));
        imagen= piso.get("ImagenPiso");
        enemigos= new ArrayList<>();

        for (int i = 0; i < numEnemigos; i++) {
            enemigos.add(new Enemy(id, false));
        }

        jefe= new Enemy(id, true);
    }

    public ArrayList<Enemy> getEnemigos(){
        return enemigos;
    }

    public Enemy getJefe() {
        return jefe;
    }
}
