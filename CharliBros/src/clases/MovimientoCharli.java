package clases;

import interfaz.Juego;


public class MovimientoCharli extends Thread {

    private int velocidad;
    private boolean saltar;
    private boolean detenerSalto1 = false;
    private boolean detenerSalto2 = true;
    private boolean saltando = false;
    private final Juego juego;
    public static boolean detenerHilo;

    public MovimientoCharli(Juego juego) {
        this.velocidad = 10;
        this.juego = juego;
    }

    @Override
    public void run() {
        int varA = 1;
        detenerHilo = false;
        while (true) {
            if (detenerHilo) {
                break;
            }
            int x = Juego.jCharli.getLocation().x;
            if (!isSaltar()) {
                int y = Juego.jCharli.getLocation().y;
                try {
                    Thread.sleep(getVelocidad());
                    Juego.jCharli.setLocation(x, (y + 1));
                    if (velocidad > 3) {
                        if (varA % 15 == 0) {
                            velocidad = velocidad - 1;
                        }
                        varA = varA + 1;
                    }
                    juego.validarChoqueTubos();
                } catch (InterruptedException e) {
                    System.out.println("Ocurrio un problema " + e);
                }
            } else {
                if (!saltando) {
                    setDetenerSalto1(false);
                    setDetenerSalto2(true);
                    saltando = true;
                    saltar1();
                } else {
                    setDetenerSalto1(true);
                    setDetenerSalto2(false);
                    saltando = false;
                    saltar2();
                }
            }
            this.juego.ValidarChoque();
        }
    }

    private void saltar1() {
        int tiempo_salto = 1;
        while (true) {
            int y = Juego.jCharli.getLocation().y;
            int x = Juego.jCharli.getLocation().x;
            try {
                Thread.sleep(getVelocidad());
                if (!isDetenerSalto1()) {
                    tiempo_salto = tiempo_salto + 1;
                    if (tiempo_salto <= 60) {
                        Juego.jCharli.setLocation(x, (y - 1));
                        if (tiempo_salto % 20 == 0) {
                            velocidad = velocidad - 1;
                        }
                    } else if (tiempo_salto >= 70) {
                        setSaltar(false);
                        setVelocidad(7);
                        break;
                    }
                    juego.validarChoqueTubos();
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error " + e);
            }
        }
    }

    private void saltar2() {
        int tiempo_salto = 1;
        while (true) {
            int y = Juego.jCharli.getLocation().y;
            int x = Juego.jCharli.getLocation().x;
            try {
                Thread.sleep(getVelocidad());
                if (!isDetenerSalto2()) {
                    tiempo_salto = tiempo_salto + 1;
                    if (tiempo_salto <= 60) {
                        Juego.jCharli.setLocation(x, (y - 1));
                        if (tiempo_salto % 20 == 0) {
                            velocidad = velocidad - 1;
                        }
                    } else if (tiempo_salto >= 70) {
                        setSaltar(false);
                        setVelocidad(7);
                        break;
                    }
                    juego.validarChoqueTubos();
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error " + e);
            }
        }
    }

    public boolean isDetenerSalto1() {
        return detenerSalto1;
    }

    public void setDetenerSalto1(boolean detenerSalto1) {
        this.detenerSalto1 = detenerSalto1;
    }

    public boolean isDetenerSalto2() {
        return detenerSalto2;
    }

    public void setDetenerSalto2(boolean detenerSalto2) {
        this.detenerSalto2 = detenerSalto2;
    }

    public boolean isSaltar() {
        return saltar;
    }

    public void setSaltar(boolean saltar) {
        this.saltar = saltar;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isDetenethilo() {
        return detenerHilo;
    }

}
