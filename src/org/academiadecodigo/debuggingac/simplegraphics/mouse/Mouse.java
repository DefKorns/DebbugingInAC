package org.academiadecodigo.debuggingac.simplegraphics.mouse;

import org.academiadecodigo.debuggingac.simplegraphics.graphics.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Instantiate a Mouse for obtaining mouse handling capability
 */
public class Mouse implements MouseListener, MouseMotionListener {
    private JPanel pane;
    MouseHandler handler;
    List<MouseEventType> mouseEventArrayList;

    /**
     * @param handler the mouse handler
     */
    public Mouse(MouseHandler handler) {
        Canvas.getInstance().addMouseListener(this);
        Canvas.getInstance().addMouseMotionListener(this);

        this.handler = handler;
        mouseEventArrayList = new ArrayList<>();
        pane = (JPanel) Canvas.getInstance().getFrame().getContentPane();
        /**
         * Windows Cursor
         */
        pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/menu/cursor00.png").getImage(), new Point(0, 0), "idle"));
        /**
         * OSX Cursor
         */
       // pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/menu/cursor00.png").getImage(), new Point(44, 175), "idle"));
    }

    /**
     * Add a new mouse event type listener
     *
     * @param eventType the event type to add
     */
    public void addEventListener(MouseEventType eventType) {
        mouseEventArrayList.add(eventType);
    }

    /**
     * Removes a mouse event type listener
     *
     * @param eventType the event type to remove
     */
    public void removeEventListener(MouseEventType eventType) {
        mouseEventArrayList.remove(eventType);
    }

    /**
     * @see MouseHandler#mouseClicked(org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent)
     * @param e the event
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_CLICKED) {
                handler.mouseClicked(new org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_CLICKED));
            }

        }

    }

    /**
     * @see MouseHandler#mouseMoved(org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent)
     * @param e the event
     */
    @Override
    public void mouseMoved(MouseEvent e) {

        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_MOVED) {
                handler.mouseMoved(new org.academiadecodigo.debuggingac.simplegraphics.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_MOVED));
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        /**
         * Windows Cursor
         */
        pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/menu/cursor02.png").getImage(), new Point(0, 0), "hit"));
        /**
         * OSX Cursor
         */
        //pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/menu/cursor02.png").getImage(), new Point(44, 175), "hit"));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /**
         * Windows Cursor
         */
        pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/menu/cursor01.png").getImage(), new Point(0, 0), "aim"));
        /**
         * OSX Cursor
         */
        //pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/menu/cursor01.png").getImage(), new Point(44, 175), "aim"));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}
