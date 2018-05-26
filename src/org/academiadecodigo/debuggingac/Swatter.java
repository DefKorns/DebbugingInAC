package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.mouse.Mouse;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.debuggingac.audio.Audio;


public class Swatter implements MouseHandler {
    private int x;
    private int y;
    private Mouse mouse;
    private Audio swatHit;
    //Sound


    public Swatter() {
        SwatterController();
        swatHit = new Audio("/resources/sounds/hammer.wav");
    }

    private void hit() {
        /*se imagem clicada fazer som
            aparecer a imagem de impacto na imagem
            adicioar pontos
            Se falhar faz só som...
         */
        swatHit.start(true);
        System.out.println("Click!");

    }

    private void SwatterController() {
        this.mouse = new Mouse(this);
        addEventListener();
    }

    private void addEventListener() {
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = (int) e.getX();
        y = (int) e.getY();
        hit();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void reset(){ x = -1; y = -1;}

}
