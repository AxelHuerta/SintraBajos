package mx.uam.ayd.proyecto.presentacion.verCitas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import org.springframework.stereotype.Component;

@Component
public class VentanaDetallesCita extends JFrame {

  private ControlVerCitas control;
  private JPanel contentPane;
  private Cita cita;
  private JLabel muestraNombre;
  private JLabel muestraCorreo;
  private JLabel muestraetiquetaFecha;
  private JLabel muestraetiquetaHora;

  public VentanaDetallesCita() {
    setResizable(false);
    setLocationRelativeTo(null); // Centramos la ventana
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 600, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(0, 0, 584, 461);
    contentPane.add(panel);
    panel.setLayout(null);

    JPanel panelLogo = new JPanel();
    panelLogo.setBounds(0, 0, 113, 66);
    panel.add(panelLogo);
    panelLogo.setLayout(null);

    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(
      new ImageIcon(VentanaDetallesCita.class.getResource("/img/Logo3.png"))
    );
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(0, 0, 113, 66);
    panelLogo.add(lblNewLabel);

    JPanel panelNombre = new JPanel();
    panelNombre.setBackground(Color.LIGHT_GRAY);
    panelNombre.setBounds(111, 0, 473, 66);
    panel.add(panelNombre);
    panelNombre.setLayout(null);

    JLabel etiquetaTitulo = new JLabel("Detalles de la cita.");
    etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaTitulo.setFont(new Font("Leelawadee UI", Font.BOLD, 15));
    etiquetaTitulo.setBounds(107, 11, 229, 38);
    panelNombre.add(etiquetaTitulo);

    JLabel etiquetaUsuario = new JLabel("Usuario: ");
    etiquetaUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaUsuario.setBounds(10, 71, 159, 34);
    panel.add(etiquetaUsuario);

    JLabel etiquetaCorreo = new JLabel("Correo: ");
    etiquetaCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaCorreo.setBounds(10, 104, 159, 34);
    panel.add(etiquetaCorreo);

    JLabel etiquetaFecha = new JLabel("Fecha: ");
    etiquetaFecha.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaFecha.setBounds(10, 137, 80, 34);
    panel.add(etiquetaFecha);

    JLabel etiquetaHora = new JLabel("Hora: ");
    etiquetaHora.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaHora.setBounds(10, 170, 80, 34);
    panel.add(etiquetaHora);

    JLabel etiquetaServicio = new JLabel("Tipo de servicio:");
    etiquetaServicio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaServicio.setBounds(10, 203, 150, 34);
    panel.add(etiquetaServicio);

    muestraNombre = new JLabel();
    muestraNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraNombre.setBounds(80, 71, 159, 34);
    panel.add(muestraNombre);

    muestraCorreo = new JLabel();
    muestraCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraCorreo.setBounds(70, 104, 159, 34);
    panel.add(muestraCorreo);

    muestraetiquetaFecha = new JLabel();
    muestraetiquetaFecha.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraetiquetaFecha.setBounds(70, 137, 100, 34);
    panel.add(muestraetiquetaFecha);

    muestraetiquetaHora = new JLabel();
    muestraetiquetaHora.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraetiquetaHora.setBounds(60, 170, 100, 34);
    panel.add(muestraetiquetaHora);

    JLabel muestraServicio = new JLabel("Consulta Medica.");
    muestraServicio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraServicio.setBounds(139, 203, 203, 34);
    panel.add(muestraServicio);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Con esto cerramos la ventana
  }

  //Muestra los datos del paciente que fue seleccionado desde la lista de usuarios.
  public void muestra(ControlVerCitas control, Cita cita) {
    this.control = control;
    this.cita = cita;
    muestraNombre.setText(cita.getNombre());
    muestraCorreo.setText(cita.getCorreo());
    muestraetiquetaFecha.setText(cita.getFecha().toString());
    muestraetiquetaHora.setText(cita.getHora().toString());
    setVisible(true);
  }

  //Cierra la ventana
  public void cierra() { // Cierra la ventana despues de guardar
    setVisible(false);
  }
}
