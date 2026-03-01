import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private NumerosManager numerosManager;
    private CadenasManager cadenasManager;

    private JTextField txtNumero;
    private JTextField txtCadena;
    private JTextArea areaResultado;

    private final Color rosaPrincipal = new Color(236, 72, 153);
    private final Color rosaHover = new Color(219, 39, 119);
    private final Color fondo = new Color(250, 245, 249);
    private final Color textoOscuro = new Color(55, 65, 81);

    public VentanaPrincipal() {

        numerosManager = new NumerosManager(10);
        cadenasManager = new CadenasManager(3, 3);

        setTitle("Gestión Moderna de Arreglos");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fuenteGeneral = new Font("Segoe UI", Font.PLAIN, 16);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 22);

        setLayout(new BorderLayout());
        getContentPane().setBackground(fondo);
        JLabel titulo = new JLabel("Gestión de Arreglos", SwingConstants.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(textoOscuro);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel panelPrincipal = new JPanel(new GridLayout(1, 2, 30, 0));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
        panelPrincipal.setBackground(fondo);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(fondo);

        txtNumero = new JTextField();
        txtNumero.setFont(fuenteGeneral);
        txtNumero.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JButton btnAgregarNumero = crearBoton("Agregar Número");

        txtCadena = new JTextField();
        txtCadena.setFont(fuenteGeneral);
        txtCadena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        JButton btnAgregarCadena = crearBoton("Agregar Cadena");

        panelIzquierdo.add(new JLabel("Número (entero o decimal):"));
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 8)));
        panelIzquierdo.add(txtNumero);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 12)));
        panelIzquierdo.add(btnAgregarNumero);

        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 25)));

        panelIzquierdo.add(new JLabel("Cadena:"));
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 8)));
        panelIzquierdo.add(txtCadena);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 12)));
        panelIzquierdo.add(btnAgregarCadena);
        
        JPanel panelDerecho = new JPanel(new BorderLayout(0, 15));
        panelDerecho.setBackground(fondo);

        JButton btnMostrar = crearBoton("Mostrar Todo");

        JPanel panelBotonMostrar = new JPanel();
        panelBotonMostrar.setLayout(new BorderLayout());
        panelBotonMostrar.setBackground(fondo);

        btnMostrar.setPreferredSize(new Dimension(0, 45)); // altura fija
        panelBotonMostrar.add(btnMostrar, BorderLayout.CENTER);

        areaResultado = new JTextArea();
        areaResultado.setFont(fuenteGeneral);
        areaResultado.setEditable(false);
        areaResultado.setBackground(Color.WHITE);
        areaResultado.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235)));

        JScrollPane scroll = new JScrollPane(areaResultado);

        panelDerecho.add(panelBotonMostrar, BorderLayout.NORTH);
        panelDerecho.add(scroll, BorderLayout.CENTER);

        panelPrincipal.add(panelIzquierdo);
        panelPrincipal.add(panelDerecho);

        add(panelPrincipal, BorderLayout.CENTER);

        btnAgregarNumero.addActionListener(e -> {
            try {
                double numero = Double.parseDouble(txtNumero.getText());
                numerosManager.agregarNumero(numero);
                txtNumero.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido");
            }
        });

        btnAgregarCadena.addActionListener(e -> {
            String texto = txtCadena.getText();
            cadenasManager.agregarCadena(texto);
            txtCadena.setText("");
        });

        btnMostrar.addActionListener(e -> {
            areaResultado.setText("NÚMEROS:\n");
            areaResultado.append(numerosManager.mostrarNumeros());
            areaResultado.append("\nCADENAS:\n");
            areaResultado.append(cadenasManager.mostrarCadenas());
        });
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        boton.setBackground(rosaPrincipal);
        boton.setForeground(Color.WHITE);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(200, 40));
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(rosaHover);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(rosaPrincipal);
            }
        });

        return boton;
    }
}