package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.menu.Menu;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardHandler;

public class Game {
    private Field field;
    private Swatter swatter;
    private boolean quit;


    public Game() {
        new Controller();
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
        swatter = new Swatter();
        startGame();

    }

    private void startGame() throws InterruptedException {
        menu();
    }

    private class Controller implements KeyboardHandler {
        private Keyboard key;
        private KeyboardEvent[] escKey;

        Controller(){
            key = new Keyboard(this);
            escKey = new KeyboardEvent[2];
            createEvent();
            setEvents();
            addEventListener();
        }

        void createEvent() {
            for (int i = 0; i < escKey.length; i++) {
                escKey[i] = new KeyboardEvent();
            }
        }

        void setEvents() {
            escKey[0].setKey(KeyboardEvent.KEY_ESC);
            escKey[0].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            escKey[1].setKey(KeyboardEvent.KEY_ESC);
            escKey[1].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        }

        void addEventListener() {
            for (KeyboardEvent event : escKey) {
                key.addEventListener(event);
            }
        }

        @Override
        public void keyPressed(KeyboardEvent e) {
            quit = true;
        }

        @Override
        public void keyReleased(KeyboardEvent e) {
        }
    }

}
