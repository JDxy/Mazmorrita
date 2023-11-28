package com.project.mazmorrita_project.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void conseguirAtaques() {

    }

    @Test
    void restarVida() {
        Enemy enemyPrueba= new Enemy();
        assertFalse(enemyPrueba.restarVida(200));
    }

    @Test
    void devolverBotin() {
        Enemy enemyPrueba= new Enemy();
        assertEquals(0, enemyPrueba.devolverBotin());
    }

    @Test
    void ataqar() {
    }

    @Test
    void defenderse() {
        Enemy enemyPrueba= new Enemy();
        enemyPrueba.defenderse("Defender");
        assertEquals(750, enemyPrueba.getDefensa());
    }
}