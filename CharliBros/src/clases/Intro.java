package clases;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.StringTokenizer;
import java.io.*;
import java.util.Random;

public class Intro extends Frame {

    Animacion lienzo;

    public Intro() throws IOException {
        super("Introd ");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(750, 500);
        lienzo = new Animacion();
        add(lienzo);
        this.setLocationRelativeTo(null);
    }

    public void moveImg() {
        for (int a = 0; a < 1250; a++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }

            lienzo.repaint();

        }

    }

}
