package com.project.mazmorrita_project.models;

import java.util.*;

import static com.project.mazmorrita_project.models.LocalConnection.ExecuteSelectSql;

public class FloorModel {

    public Enemy selectRandomEnemy(Integer floor, Boolean isBoss){
        String[] listValues = new String[1];
        listValues[0] = floor.toString();
        List<HashMap<String,String>> selectedRows = ExecuteSelectSql("SELECT * FROM Enemigo WHERE IdPiso = ?", listValues);
        ArrayList<Enemy> enemies = new ArrayList<>();

        for (HashMap<String,String> row : selectedRows) {
            Enemy enemy = new Enemy(floor,isBoss);

            enemies.add(enemy);
        }

        if (!enemies.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(enemies.size());
            return enemies.get(randomIndex);
        } else {
            return null;
        }
    }


}
