package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.menu.Menu;

public class Game {
    private Field field;


    public Game() {
        System.out.println("game start");
    }

    public void menu() throws InterruptedException {
        Menu menu = new Menu();
        menu.selection();
        init();
    }

    private void init() throws InterruptedException {
        field = new FieldEvent();
        field.init();
        startGame();

    }

    private void startGame() throws InterruptedException {
        menu();
    }

}
