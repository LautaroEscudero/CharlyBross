package interfaz;

import clases.MovimientoCharli;
import clases.MovimientoTubos;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.edisoncor.gui.panel.PanelImage;
import sonidos.Sonido;



public class Juego extends javax.swing.JFrame {

    public static JLabel jCharli;
    public static JLabel jLabel2;
    public static JLabel jLabel3;
    public static JLabel jLabel4;
    private final JPanel jPanel1;
    public static JLabel jPuntaje;
    public PanelImage jSuelo;
    public static JLabel jTubo_abajo1;
    public static JLabel jTubo_abajo2;
    public static JLabel jTubo_arriba1;
    public static JLabel jTubo_arriba2;
    public static PanelImage panelImage1;
    private MovimientoCharli mvnt_Charli;
    private MovimientoTubos mvnt_tubos;
    private boolean empezar = false;
    private final Login login;
    private JPanel panel1;
    private JPanel panel2;
    public String nombre;
    static public boolean con_exitosa = false;
    Point posicionCharli;
    public String ruta = "";
    int velocidad = 4;

    public Juego() {
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jSuelo = new org.edisoncor.gui.panel.PanelImage();
        jPuntaje = new javax.swing.JLabel();
        jCharli = new javax.swing.JLabel();
        jTubo_arriba1 = new javax.swing.JLabel();
        jTubo_abajo1 = new javax.swing.JLabel();
        jTubo_arriba2 = new javax.swing.JLabel();
        jTubo_abajo2 = new javax.swing.JLabel();
        initComponents();
        this.setLocationRelativeTo(null);
        login = new Login();
        this.setTitle("CHARLI BROS");
        posicionCharli = jCharli.getLocation();
        this.jPanel1.setSize(400, 607);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png")));
        panelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
             
            }
        });
        panelImage1.setLayout(null);

        jSuelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/piso.png")));

        javax.swing.GroupLayout jSueloLayout = new javax.swing.GroupLayout(jSuelo);
        jSuelo.setLayout(jSueloLayout);
        jSueloLayout.setHorizontalGroup(
                jSueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 580, Short.MAX_VALUE)
        );
        jSueloLayout.setVerticalGroup(
                jSueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 180, Short.MAX_VALUE)
        );

        panelImage1.add(jSuelo);
        jSuelo.setBounds(-130, 470, 580, 180);

        jPuntaje.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jPuntaje.setForeground(new java.awt.Color(255, 255, 255));
        jPuntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPuntaje.setText("0");
        panelImage1.add(jPuntaje);
        jPuntaje.setBounds(0, 10, 400, 49);

        jCharli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/charli.png"))); // NOI18N
        jCharli.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               
            }
        });
        panelImage1.add(jCharli);
        jCharli.setBounds(70, 230, 34, 34);

        jTubo_arriba1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tubo_1.png"))); 
        panelImage1.add(jTubo_arriba1);
        jTubo_arriba1.setBounds(70, -120, 52, 320);

        jTubo_abajo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tubo_2.png")));
        panelImage1.add(jTubo_abajo1);
        jTubo_abajo1.setBounds(70, 280, 52, 320);

        jTubo_arriba2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tubo_1.png")));
        panelImage1.add(jTubo_arriba2);
        jTubo_arriba2.setBounds(290, -120, 52, 320);

        jTubo_abajo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tubo_2.png"))); 
        panelImage1.add(jTubo_abajo2);
        jTubo_abajo2.setBounds(290, 280, 52, 320);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }

   

   
    
    
   
   


}
