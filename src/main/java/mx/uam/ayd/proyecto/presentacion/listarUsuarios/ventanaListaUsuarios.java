package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@SuppressWarnings("serial")
@Component
public class ventanaListaUsuarios extends JFrame implements MouseListener {

  private JPanel contentPane;
  private JTable tablaUsuarios;
  //////////////////////////////////////////////
  // de ControlPrincipal a ControlListarUsuarios
  //////////////////////////////////////////////
  private ControlListarUsuarios control;
  private DefaultTableModel model;

  /**
   * Create the frame.
   */
  public ventanaListaUsuarios() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);// Centramos la ventana
    setBounds(100, 100, 600, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panelRaiz = new JPanel();
    panelRaiz.setBounds(0, 0, 584, 461);
    contentPane.add(panelRaiz);
    panelRaiz.setLayout(null);

    JPanel panelLogo = new JPanel();
    panelLogo.setBounds(0, 0, 113, 66);
    panelRaiz.add(panelLogo);

    JPanel panelNombrePag = new JPanel();
    panelNombrePag.setLayout(null);
    panelNombrePag.setBackground(Color.LIGHT_GRAY);
    panelNombrePag.setBounds(111, 0, 473, 66);
    panelRaiz.add(panelNombrePag);

    JLabel lblListaDeClientes = new JLabel("Lista de clientes.");
    lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
    lblListaDeClientes.setFont(new Font("Leelawadee UI", Font.BOLD, 15));
    lblListaDeClientes.setBounds(107, 11, 229, 38);
    panelNombrePag.add(lblListaDeClientes);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 77, 564, 209);
    panelRaiz.add(scrollPane);

    tablaUsuarios = new JTable();
    model = new DefaultTableModel();
    tablaUsuarios.setModel(model);
    tablaUsuarios.addMouseListener(this);
    // Agregamos los columnos
    model.addColumn("ID"); // Columna ID
    model.addColumn("Nombre"); // Columna Nombre
    model.addColumn("Apellidos"); // Columna Apellidos
    model.addColumn("Diagnostico"); // Columna Diagnostico
    model.addColumn("Boton"); // Columna Boton
    // Agregamos el Scroll para la tabla.
    scrollPane.setViewportView(tablaUsuarios);
    scrollPane.setViewportView(tablaUsuarios);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Con esto cerramos la ventana
  }

  //////////////////////////////////////////////
  // parametro de ControlPrincipal a ControlListarUsuarios
  //////////////////////////////////////////////
  public void muestra(ControlListarUsuarios control) {
    this.control = control;
    this.llenarTabla();
    setVisible(true);
  }

  // Muestra la nueva tabla.

  public void llenarTabla() {
    List<Usuario> listaImprimir = control.obtenPacientes();
    // Se asigna a la lista la persona
    for (Usuario usuario : listaImprimir) {
      Object[] fila = new Object[5];
      fila[0] = usuario.getIdUsuario();
      fila[1] = usuario.getNombre();
      fila[2] = usuario.getApellido();
      fila[3] = usuario.getDiagnostico();
      fila[4] = "Consultar";
      // Aqui deberia agregar el boton pero no se como.
      model.addRow(fila); // Nota, debes agregar un MouseClicked que te conecte a los campos
      // Al dar clic toma los datos del renglon y los muestra en una ventana
      // emergente.

    }
  }

  // Muestra la nueva ventana.
  public void muestraNuevo() {
    this.llenarTabla();
    setVisible(true);
  }

  // Una vez terminan los primeros eventos deshabilita la ventana y limpia la
  // tabla.
  public void termina() {
    setVisible(false);
    Clear_Table1();
  }

  // Limpia los elementos de la tabla.
  private void Clear_Table1() {
    for (int i = 0; i < model.getRowCount(); i++) {
      model.removeRow(i);
      i -= 1;
    }
  }

  public Usuario validarSeleccionMouse(int fila) { // Metodo en el que se valida el usuario.
    Usuario usuario = new Usuario();
    usuario.setIdUsuario((long) tablaUsuarios.getValueAt(fila, 0));
    usuario.setNombre(tablaUsuarios.getValueAt(fila, 1).toString());
    usuario.setApellido(tablaUsuarios.getValueAt(fila, 2).toString());
    usuario.setDiagnostico(tablaUsuarios.getValueAt(fila, 3).toString());
    return usuario; // Se almacenan los datos del paciente.
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // Este evento se activa cuando se da clic en un elemento.
    int fila = tablaUsuarios.rowAtPoint(e.getPoint()); // Con esto sabemos que fila esta ejecutando el evento.
    int columna = tablaUsuarios.columnAtPoint(e.getPoint());
    Usuario pac = new Usuario(); // Variable local que almacenara al usuario seleccionado.
    if (columna == 4) { // Columna 4 referente a la columna de consulta
      pac = validarSeleccionMouse(fila); // Se obtienen el objeto usuario al cual se le realizara la consulta
      control.recuperaUsuario(pac); // Con este metodo se hace referencia al Usuario en turno

    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }
}