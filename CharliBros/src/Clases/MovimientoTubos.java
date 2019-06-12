package Clases;

import interfaz.Juego;
import interfaz.Juego;
import sonidos.Sonido;


public class MovimientoTubos extends Thread {

    static int velocidad;
    private static int puntos;

    public MovimientoTubos() {
        velocidad = 7;
        puntos = 0;
        ocultarTubos();
    }

    private static synchronized void sumarPuntos() {
        int tubo1 = Juego.jTubo_arriba1.getLocation().x;
        int tubo2 = Juego.jTubo_arriba2.getLocation().x;
        if (tubo1 == 90) {
            Sonido.puntos();
            puntos = puntos + 1;
            Juego.jPuntaje.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                velocidad = velocidad - 1;
            }
        } else if (tubo2 == 90) {
            Sonido.puntos();
            puntos = puntos + 1;
            Juego.jPuntaje.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                velocidad = velocidad - 1;
            }
        }
    }

    @Override
    public void run() {
      
    }

    private void ocultarTubos() {
       
    }

    public int getVelocidad() {
        return velocidad;
    }

    private int generarPosicionAleatoria() {
        int numero = (int) (Math.random() * (0 - (-200)) + (-200));
        return numero;
    }

}
