package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Color;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.Text;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

public class FieldEvent implements Field {
    private static int fieldWidth;
    private static int fieldHeight;
    private Picture background;


    public FieldEvent() {
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
    public void init() throws InterruptedException {
        background.draw();
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
