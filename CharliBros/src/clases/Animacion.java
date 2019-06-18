package clases;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Animacion extends Canvas {

    private String[] historiasTxt;
    private double[][] pixeles, pixeles3D, preRotacion;
    private int[][] estrellas;
    private int historiaTam, maxX, maxY;
    private int numPixeles = 0;
    private boolean readData = false;
    Random generator = new Random();

    Animacion() throws IOException {

        //  LeerTexto f = new LeerTexto("C:\\Users\\arisa\\Documents\\NetBeansProjects\\CharliBrosDos\\src\\texto\\"
        //  + "introduccion.txt");
        File file = new File(".");
        String ruta = file.getAbsolutePath();
        LeerTexto f = new LeerTexto(ruta + "/src/texto/introduccion.txt");

        historiasTxt = f.getHistoria();
        historiaTam = f.getSize();

        pixeles = new double[30000][3];
        preRotacion = new double[30000][3];
        pixeles3D = new double[30000][3];

        estrellas = new int[80][4];

        for (int i = 0; i < estrellas.length; i++) {
            estrellas[i][2] = (Math.abs(generator.nextInt()) % 3) + 1;
            estrellas[i][3] = estrellas[i][2];

            estrellas[i][0] = (Math.abs(generator.nextInt()) % 599) + 10;
            estrellas[i][1] = (Math.abs(generator.nextInt()) % 499) + 10;
        }

        BufferedImage bufferImg = new BufferedImage(650, 900,
                Image.SCALE_DEFAULT);
        Graphics gBuffer = bufferImg.getGraphics();

        Font letra = new Font("Arial", Font.PLAIN, 20);
        gBuffer.setFont(letra);

        for (int i = 0; i < historiaTam; i++) {
            gBuffer.drawString(historiasTxt[i], 10, i * 20 + 30);
        }

        for (int i = 0; i < 650 - 1; i++) {
            for (int j = 0; j < 900 - 1; j++) {
                if (bufferImg.getRGB(i, j) == -1) {
                    pixeles[numPixeles][0] = 0;
                    pixeles[numPixeles][1] = i - 135;
                    pixeles[numPixeles][2] = j + 410;
                    numPixeles = numPixeles + 1;

                }
            }
        }

    }

    public void paint(Graphics g) {
        Dimension d = getSize();

        maxX = d.width - 1;
        maxY = d.height - 1;

        double t = 0.0, Eye = 635.0;

        int origenX = maxX / 2,
                origenY = maxY / 2;

        BufferedImage bufferImg = new BufferedImage(getWidth(), getHeight(),
                Image.SCALE_DEFAULT);
        Graphics gBuffer = bufferImg.getGraphics();

        for (int i = 0; i < estrellas.length; i++) {
            gBuffer.setColor(Color.lightGray);
            gBuffer.fillOval(estrellas[i][0] - 1, estrellas[i][1] - 1, estrellas[i][2] + 2, estrellas[i][3] + 2);

            gBuffer.setColor(Color.white);

            gBuffer.fillOval(estrellas[i][0], estrellas[i][1], estrellas[i][2], estrellas[i][3]);
        }

        rotarY(-59);

        gBuffer.setColor(Color.yellow);

        for (int i = 0; i < numPixeles; i++) {
            for (int j = 0; j < 3; j++) {

                if (j == 0) {
                    t = 1.0 / (1.0 - (pixeles[i][j] / Eye));
                } else {
                    pixeles3D[i][j - 1] = t * pixeles[i][j];
                }
            }
        }

        for (int i = 0; i < numPixeles; i++) {
            gBuffer.drawLine((int) Math.round(origenX + pixeles3D[i][0]),
                    (int) Math.round(pixeles3D[i][1]) + 1,
                    (int) Math.round(origenX + pixeles3D[i][0]),
                    (int) Math.round(pixeles3D[i][1]) - 1);
            gBuffer.drawLine((int) Math.round(origenX + pixeles3D[i][0]) + 1,
                    (int) Math.round(pixeles3D[i][1]) + 1,
                    (int) Math.round(origenX + pixeles3D[i][0]) + 1,
                    (int) Math.round(pixeles3D[i][1]) - 1);
            gBuffer.drawLine((int) Math.round(origenX + pixeles3D[i][0]) - 1,
                    (int) Math.round(pixeles3D[i][1]) + 1,
                    (int) Math.round(origenX + pixeles3D[i][0]) - 1,
                    (int) Math.round(pixeles3D[i][1]) - 1);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }

        g.drawImage(bufferImg, 0, 0, this);
        rotarY(59);
        transImg(0, 0, -2);

    }

    public void rotarY(double ry) {
        double radAngle = (ry * Math.PI) / 180,
                newX = 0,
                newY = 0,
                newZ = 0;

        for (int i = 0; i < numPixeles; i++) {
            newX = (pixeles[i][0] * Math.cos(radAngle))
                    + (pixeles[i][2] * (-Math.sin(radAngle)));
            newY = pixeles[i][1];
            newZ = (pixeles[i][0] * Math.sin(radAngle))
                    + (pixeles[i][2] * Math.cos(radAngle));

            pixeles[i][0] = newX;
            pixeles[i][1] = newY;
            pixeles[i][2] = newZ;
        }

    }

    public void transImg(double sx, double sy, double sz) {

        for (int i = 0; i < numPixeles; i++) {
            pixeles[i][0] = pixeles[i][0] + sx;
            pixeles[i][1] = pixeles[i][1] + sy;
            pixeles[i][2] = pixeles[i][2] + sz;
        }

    }

    public void update(Graphics g) {
        paint(g);
    }

}
