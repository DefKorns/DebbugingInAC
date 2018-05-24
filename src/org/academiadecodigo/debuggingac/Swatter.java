package org.academiadecodigo.debuggingac;

import org.academiadecodigo.debuggingac.audio.Audio;
import org.academiadecodigo.debuggingac.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Swatter extends JFrame {
    private Picture menuBG;
    private Picture menuLoader;
    private Audio menu;
    private Audio loading;
    private JPanel pane;

    public Swatter() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(getListener());
        setSize(1280, 720);
        setTitle("Debuggin' in <AC_>");
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/game/cursor.png").getImage(), new Point(0, 0), "custom cursor"));

        pane = (JPanel) getContentPane();
        setVisible(true);
    }

    private MouseListener getListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/game/luigi_jump02.png").getImage(), new Point(180, 50), "custom cursor"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                pane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("resources/images/game/luigi_jump01.png").getImage(), new Point(180, 50), "custom cursor"));


            }
        };
    }


    public static void main(String... s) {
        new Swatter();
    }
}
