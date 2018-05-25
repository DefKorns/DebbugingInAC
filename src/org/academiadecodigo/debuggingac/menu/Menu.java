package org.academiadecodigo.debuggingac.menu;

import org.academiadecodigo.debuggingac.simplegraphics.mouse.Mouse;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseHandler;


public class Menu {
    private MenuEvent menuEvent;
    private int mouseX;
    private int mouseY;
    private Buttons play;
    private Buttons tutorial;
    private Buttons credits;
    private Buttons back;
    private boolean selection;
    private boolean secondaryMenu;
    
    public Menu() throws InterruptedException {
        new MouseMenu();
        menuEvent = new MenuEvent();
        loading();
        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        tutorial = ButtonFactory.getNewButton(ButtonType.TUTORIAL);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        back = ButtonFactory.getNewButton(ButtonType.BACK);
        selection = false;
        secondaryMenu = false;
    }

    private int getMouseX() {
        return mouseX;
    }

    private int getMouseY() {
        return mouseY;
    }


    public void selection() throws InterruptedException {
        while (!selection) {
            Thread.sleep(1);
            if (secondaryMenu) {
                if ((getMouseX() >= back.getStartX() && getMouseX() <= back.getEndX()) &&
                        (getMouseY() >= back.getStartY() && getMouseY() <= back.getEndY())) {
                    menuEvent.removeCredits();
                    menuEvent.removeTutorial();
                    Thread.sleep(200);
                    secondaryMenu = false;
                    mainMenu();
                }
            }
            if ((getMouseX() >= play.getStartX() && getMouseX() <= play.getEndX()) &&
                    (getMouseY() >= play.getStartY() && getMouseY() <= play.getEndY())) {
                menuEvent.killSoundMenu();
                selection = true;
            }
            if ((getMouseX() >= tutorial.getStartX() && getMouseX() <= tutorial.getEndX()) &&
                    (getMouseY() >= tutorial.getStartY() && getMouseY() <= tutorial.getEndY())) {
                secondaryMenu = true;
                tutorial();
            }
            if ((getMouseX() >= credits.getStartX() && getMouseX() <= credits.getEndX()) &&
                    (getMouseY() >= credits.getStartY() && getMouseY() <= credits.getEndY())) {
                secondaryMenu = true;
                credits();
            }
        }
    }

    private void loading() throws InterruptedException {
        menuEvent.init();
        menuEvent.soundMenu();
        mainMenu();
    }
    private void tutorial() {
        menuEvent.tutorial();
    }
    private void credits() {
        menuEvent.credits();
    }

    private void mainMenu() {
        menuEvent.mainMenu();
    }


    private class MouseMenu implements MouseHandler {
        private Mouse mouse;

        MouseMenu() {
            this.mouse = new Mouse(this);
            addEventListener();
        }

        void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            mouseX = (int) e.getX();
            mouseY = (int) e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

}
