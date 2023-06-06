package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class VentanaVerUsaurio extends JFrame {

  private JPanel contentPane;
  private ControlVerUsuario control;
  private Usuario usuario;
  private JLabel muestraPerfil;
  private JLabel muestraNombre;
  private JLabel muestraApellidoPaterno;
  private JLabel muestraApellidoMaterno;
  private JLabel muestraSexo;
  private JLabel muestraCorreo;
  private JLabel muestraFechaNacimiento;
  private JLabel muestraDomicilio;
  private JLabel muestraTelefono;
  private JLabel muestraDiagnostico;
  private Font textoNormal;
  private Font textoBold;

  /**
   * Create the frame.
   */
  public VentanaVerUsaurio() {
    textoNormal = new Font("Roboto Light", Font.PLAIN, 16);
    textoBold = new Font("Roboto Light", Font.BOLD, 16);

    setResizable(false);
    setLocationRelativeTo(null); // Centramos la ventana
    setBounds(100, 100, 900, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panelRaiz = new JPanel();
    panelRaiz.setBackground(Color.white);
    panelRaiz.setBounds(0, 0, 884, 561);
    contentPane.add(panelRaiz);
    panelRaiz.setLayout(null);

    JPanel panelLogo = new JPanel();
    panelLogo.setBounds(0, 0, 121, 88);
    panelRaiz.add(panelLogo);
    panelLogo.setLayout(null);

    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setIcon(
      new ImageIcon(ventanaListaUsuarios.class.getResource("/img/Logo3.png"))
    );
    lblNewLabel.setBounds(0, 0, 121, 88);
    panelLogo.add(lblNewLabel);

    JPanel panelNombrePag = new JPanel();
    panelNombrePag.setLayout(null);
    panelNombrePag.setBackground(Color.lightGray);
    panelNombrePag.setBounds(121, 0, 763, 88);
    panelRaiz.add(panelNombrePag);

    JLabel lblListaDeClientes = new JLabel("Perfil del paciente.");
    lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
    lblListaDeClientes.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
    lblListaDeClientes.setBounds(254, 27, 200, 38);
    panelNombrePag.add(lblListaDeClientes);

    muestraPerfil = new JLabel();
    muestraPerfil.setFont(textoBold);
    muestraPerfil.setBounds(30, 100, 500, 50);
    panelRaiz.add(muestraPerfil);

    JLabel labelDatosGenerales = new JLabel("Datos generales");
    labelDatosGenerales.setFont(textoBold);
    labelDatosGenerales.setBounds(30, 130, 500, 50);
    panelRaiz.add(labelDatosGenerales);

    muestraNombre = new JLabel();
    muestraNombre.setFont(textoNormal);
    muestraNombre.setBounds(30, 160, 500, 50);
    panelRaiz.add(muestraNombre);

    muestraApellidoPaterno = new JLabel();
    muestraApellidoPaterno.setFont(textoNormal);
    muestraApellidoPaterno.setBounds(30, 190, 500, 50);
    panelRaiz.add(muestraApellidoPaterno);

    muestraApellidoMaterno = new JLabel();
    muestraApellidoMaterno.setFont(textoNormal);
    muestraApellidoMaterno.setBounds(30, 220, 500, 50);
    panelRaiz.add(muestraApellidoMaterno);

    muestraFechaNacimiento = new JLabel();
    muestraFechaNacimiento.setFont(textoNormal);
    muestraFechaNacimiento.setBounds(400, 160, 500, 50);
    panelRaiz.add(muestraFechaNacimiento);

    muestraSexo = new JLabel();
    muestraSexo.setFont(textoNormal);
    muestraSexo.setBounds(400, 190, 500, 50);
    panelRaiz.add(muestraSexo);

    JLabel labelDatosContacto = new JLabel("Datos de contacto");
    labelDatosContacto.setFont(textoBold);
    labelDatosContacto.setBounds(30, 250, 500, 50);
    panelRaiz.add(labelDatosContacto);

    muestraCorreo = new JLabel();
    muestraCorreo.setFont(textoNormal);
    muestraCorreo.setBounds(30, 280, 500, 50);
    panelRaiz.add(muestraCorreo);

    muestraTelefono = new JLabel();
    muestraTelefono.setFont(textoNormal);
    muestraTelefono.setBounds(30, 310, 500, 50);
    panelRaiz.add(muestraTelefono);

    muestraDomicilio = new JLabel();
    muestraDomicilio.setFont(textoNormal);
    muestraDomicilio.setBounds(400, 280, 500, 50);
    panelRaiz.add(muestraDomicilio);

    JLabel labelDiagnostico = new JLabel("Diagnóstico:");
    labelDiagnostico.setFont(textoBold);
    labelDiagnostico.setBounds(30, 340, 500, 50);
    panelRaiz.add(labelDiagnostico);

    muestraDiagnostico = new JLabel();
    muestraDiagnostico.setFont(textoNormal);
    muestraDiagnostico.setBounds(30, 370, 500, 50);
    panelRaiz.add(muestraDiagnostico);

    // TODO: btn regresar
    // botón para regresar al menu
    JButton btnRegresar = new JButton("Regresar");
    btnRegresar.setBounds(30, 600, 117, 29);
    contentPane.add(btnRegresar);

			btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
  }

  /**
   *
   *  inicia la ventana para consultar los datos de usuario
   *  @param ControlVerUsuario
   *  @param Usuario
   *
   */
  public void muestra(ControlVerUsuario control, Usuario usuario) {
    this.control = control;
    this.usuario = usuario;
    String diagnostico = "";

    // comporbar si existen diagnosticos para este usaurio
    if (usuario.getDiagnostico().compareTo("") == 0) {
      diagnostico = "Aún no hay diagnósticos";
    } else {
      diagnostico = usuario.getDiagnostico();
    }

    muestraPerfil.setText(
      "Perfil del paciente: " +
      usuario.getNombre() +
      " " +
      usuario.getApellido() +
      " " +
      usuario.getApellidomaterno()
    );

    muestraNombre.setText("Nombre(s): " + usuario.getNombre());
    muestraApellidoPaterno.setText(
      "Apellido paterno: " + usuario.getApellido()
    );
    muestraApellidoMaterno.setText(
      "Apellido materno: " + usuario.getApellidomaterno()
    );
    muestraFechaNacimiento.setText(
      // TODO: Solo la fecha, hay que quitar la hora
      "Fecha de nacimiento: " + usuario.getFechaNa()
    );
    muestraSexo.setText("Sexo: " + usuario.getSexo());
    setVisible(true);
    muestraCorreo.setText("Correo: " + usuario.getCorreo());
    muestraTelefono.setText("Teléfono: " + usuario.getTelefono());
    muestraDomicilio.setText("Domicilio: " + usuario.getDomicilio());
    muestraDiagnostico.setText(diagnostico);
  }
}
