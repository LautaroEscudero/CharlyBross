package principal;

import interfaz.Juego;
import clases.Intro;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        try {
            Intro intro = new Intro();
            intro.show();
            intro.moveImg();
            intro.setVisible(false);

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            new Juego().setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
