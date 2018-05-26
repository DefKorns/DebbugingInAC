package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class FieldEvent implements Field {
    private static int fieldWidth;
    private static int fieldHeight;
    private Picture background;


    public FieldEvent() {
        background = new Picture(0,0, "resources/images/menu/goomba.jpg");
        fieldWidth = background.getWidth();
        fieldHeight = background.getHeight();
    }

    public static int getFieldWidth() {
        return fieldWidth;
    }

    public static int getFieldHeight() {
        return fieldHeight;
    }


    @Override
    public void init() throws InterruptedException{
        background.draw();
       // Thread.sleep(10);
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

}
