package org.academiadecodigo.debuggingac.simplegraphics.test;

import org.academiadecodigo.debuggingac.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.debuggingac.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.Mouse;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;
import org.academiadecodigo.debuggingac.simplegraphics.graphics.*;

public class Tester implements KeyboardHandler, MouseHandler {

    public static void main(String[] args) throws InterruptedException {

        Tester t = new Tester();
        t.test();

    }

    public void test() throws InterruptedException {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        Rectangle rect = new Rectangle(10, 10, 400, 400);
        rect.setColor(Color.BLACK);
        rect.draw();

        Rectangle smallRect = new Rectangle(50, 50, 100, 100);
        smallRect.setColor(Color.RED);
        smallRect.fill();

        Ellipse ellipse = new Ellipse(30, 30, 50, 60);
        ellipse.setColor(Color.YELLOW);
        ellipse.fill();

        Line line = new Line(200, 200, 300, 250);
        line.setColor(Color.BLUE);
        line.draw();

        Text text = new Text(20, 180, "Simple Graphics");
        text.setColor(Color.MAGENTA);
        text.draw();

        Picture pic = new Picture(20, 220, "http://static0.bigstockphoto.com/thumbs/3/5/2/small2/25346960.jpg");
        pic.draw();

        Thread.sleep(2000);

        smallRect.translate(100, 0);
        ellipse.translate(20, 20);
        line.translate(20, -10);
        text.translate(20, 20);
        pic.translate(40, 0);

        Thread.sleep(2000);

        smallRect.grow(10, 10);
        ellipse.grow(-20, -20);
        line.grow(10, 10);
        text.grow(5, 5);
        pic.grow(-50, -50);

        Thread.sleep(2000);

        text.setText("Academia de Codigo");
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        System.out.println("SPACE KEY PRESSED");

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       System.out.println(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        System.out.println(e);

    }
}
