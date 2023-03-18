package mx.uam.ayd.proyecto.presentacion.reagendarCita;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.springframework.stereotype.Component;

import com.toedter.calendar.JDateChooser;

import mx.uam.ayd.proyecto.negocio.modelo.Cita;

@Component
public class VentanaReagendarCita extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private ControlReagendarCita control;
  private JLabel lblHora;
  private JLabel lblAgendarCita;
  private JLabel lblFecha;
  private JLabel lblProxFecha;
  private JLabel lblServicio;
  private JComboBox<String> comboBoxHoras;
  private JComboBox<String> comboBoxServicios;
  private JTable proximasCitas;
  public String idUsuario;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          VentanaReagendarCita frame = new VentanaReagendarCita();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public VentanaReagendarCita() {
    setTitle("Reaendar cita");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 600);
    setSize(800, 450);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    lblAgendarCita = new JLabel("Reagendar Cita");
    lblAgendarCita.setBounds(5, 12, 500, 17);
    lblAgendarCita.setHorizontalAlignment(SwingConstants.CENTER);
    contentPane.add(lblAgendarCita);

    // TEXTO PROXIMA FECHA
    lblProxFecha = new JLabel("Proximas Citas");
    lblProxFecha.setBounds(25, 32, 100, 17);
    contentPane.add(lblProxFecha);

    // PROXIMA CITA
    proximasCitas = new JTable();
    proximasCitas.setBounds(30, 50, 400, 200);
    proximasCitas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("Fecha");
    modelo.addColumn("Hora");
    modelo.addColumn("Servicio");
    modelo.addRow(new Object[] { "", "", "" });

    proximasCitas.setModel(modelo);
    contentPane.add(proximasCitas);

    // FECHA
    lblFecha = new JLabel("Fecha");
    lblFecha.setBounds(450, 32, 60, 20);
    contentPane.add(lblFecha);

    JDateChooser fechaCalendario = new JDateChooser(); // Seleccionar la fecha
    fechaCalendario.setBounds(450, 50, 100, 20);
    contentPane.add(fechaCalendario);

    // HORA
    lblHora = new JLabel("Hora");
    lblHora.setBounds(450, 100, 60, 20);
    contentPane.add(lblHora);

    comboBoxHoras = new JComboBox<>();
    comboBoxHoras.setBounds(450, 120, 100, 20);
    contentPane.add(comboBoxHoras);

    // SERVICIOS
    lblServicio = new JLabel("Servicio");
    lblServicio.setBounds(450, 180, 170, 20);
    contentPane.add(lblServicio);

    comboBoxServicios = new JComboBox<>();
    comboBoxServicios.setBounds(450, 200, 250, 20);
    contentPane.add(comboBoxServicios);

    // BOTONES

    // botón para agendar
    JButton btnAgendar = new JButton("Agendar");
    btnAgendar.setBounds(600, 300, 117, 29);
    contentPane.add(btnAgendar);

    // boton para eliminar
    JButton btnEliminar = new JButton("Eliminar Cita");
    btnEliminar.setBounds(450, 300, 117, 29);
    contentPane.add(btnEliminar);

    // botón para regresar al menu
    JButton btnRegresar = new JButton("Regresar");
    btnRegresar.setBounds(30, 300, 117, 29);
    contentPane.add(btnRegresar);

    // listeners
    btnAgendar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // TOMAR LA FECHA DEL CALENDARIO
        Date datev = fechaCalendario.getDate();
        if (datev == null) {
          JOptionPane.showMessageDialog(null, "Debe proporcionar una fecha valida.");
          return;
        }

        LocalDate date = fechaCalendario.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("H:mm");

        control.agregarCita(date, LocalTime.parse((String) comboBoxHoras.getSelectedItem(), formatoHora),
            (String) comboBoxServicios.getSelectedItem(), (long) 123);// este lo deberia de traer desde que inicia el
                                                                      // proyecto
        control.comprobarCitasDia(date);

        /// ACTUALIZAR EL PANEL
        List<Cita> citas = control.ProximasCitas(((long) 123)); // buscar en la base
                                                                // de datos

        DefaultTableModel model = (DefaultTableModel) proximasCitas.getModel();
        model.setRowCount(0); // limpia la tabla antes de agregar las nuevas filas
        for (Cita cita : citas) {
          Object[] row = { cita.getFecha(), cita.getHora(), cita.getServicio() };
          model.addRow(row);

          TableColumnModel columnModel = proximasCitas.getColumnModel();
          TableColumn fechaColumn = columnModel.getColumn(0);
          TableColumn horaColumn = columnModel.getColumn(1);
          TableColumn servicioColumn = columnModel.getColumn(2);
          fechaColumn.setPreferredWidth(10);
          horaColumn.setPreferredWidth(10);
          servicioColumn.setPreferredWidth(90);

        }

      }
    });

    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        int selectedRow = proximasCitas.getSelectedRow();
        if (selectedRow != -1) { // si hay una fila seleccionada

          DefaultTableModel modelo = (DefaultTableModel) proximasCitas.getModel();
          LocalDate fecha = LocalDate.parse(modelo.getValueAt(selectedRow, 0).toString());
          LocalTime hora = LocalTime.parse(modelo.getValueAt(selectedRow, 1).toString());
          control.eliminarCita(fecha, hora, (long) 123); // idUsuario que debe de iniciar con la historia de
                                                         // usuario
          modelo.removeRow(selectedRow);
          proximasCitas.repaint(); // actualiza la vista de la tabla
        } else {
          // muestra un mensaje de error o realiza alguna otra acción
          JOptionPane.showMessageDialog(null, "Por favor seleccione una cita para eliminar.");
        }

      }
    });

    btnRegresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        control.termina();
      }
    });

  }

  public void muestra(ControlReagendarCita control) {
    this.control = control;

    /// MOSTRAR LAS CITAS ASOCIADAS AL USUARIO DESDE UN PRINCIPIO
    List<Cita> citas = control.ProximasCitas((long) 123); // buscar en la base de
                                                          // datos idUsuario

    DefaultTableModel model = (DefaultTableModel) proximasCitas.getModel();
    model.setRowCount(0); // limpia la tabla antes de agregar las nuevas filas
    for (Cita cita : citas) {
      Object[] row = { cita.getFecha(), cita.getHora(), cita.getServicio() };
      model.addRow(row);

      TableColumnModel columnModel = proximasCitas.getColumnModel();
      TableColumn fechaColumn = columnModel.getColumn(0);
      TableColumn horaColumn = columnModel.getColumn(1);
      TableColumn servicioColumn = columnModel.getColumn(2);
      fechaColumn.setPreferredWidth(10);
      horaColumn.setPreferredWidth(10);
      servicioColumn.setPreferredWidth(90);
    }
    /////////////

    DefaultComboBoxModel<String> comboBoxModelH = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboBoxModelS = new DefaultComboBoxModel<>();
    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("H:mm");
    LocalTime[] lapzos = new LocalTime[8];

    int i = 8;
    for (LocalTime lap : lapzos) {
      lap = LocalTime.parse(i + ":00", formatoHora);
      comboBoxModelH.addElement(lap.toString());
      i++;
    }

    comboBoxHoras.setModel(comboBoxModelH);

    String[] servicios = new String[9];
    servicios[0] = "Examen Bucodental Inicial";
    servicios[1] = "Procedimientos de obturación";
    servicios[2] = "Extracciones dentales";
    servicios[3] = "Servicios de limpieza dental";
    servicios[4] = "Ortodoncia";
    servicios[5] = "Tratamientos de blanqueamiento";
    servicios[6] = "Puentes dentales";
    servicios[7] = "Tratamientos de nervio";
    servicios[8] = "Carillas dentales";

    for (String servicio : servicios) {
      comboBoxModelS.addElement(servicio);
    }

    comboBoxServicios.setModel(comboBoxModelS);

    setVisible(true);

  }

  public void muestraDialogoConMensaje(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje);
  }
}