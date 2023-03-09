package mx.uam.ayd.proyecto.presentacion.agendarCita;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
// import javax.swing.JComboBox;

@Component
public class VentanaAgendarCita extends JFrame {
	private JPanel contentPane;
	private ControlAgendarCita control;
	private JTextField textFieldFecha;
	private JTextField textFieldHora;
	private JLabel lblHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgendarCita frame = new VentanaAgendarCita();
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
	public VentanaAgendarCita() {
		setTitle("Agendar cita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAgendarCita = new JLabel("Agendar Cita");
		lblAgendarCita.setBounds(5, 12, 437, 17);
		lblAgendarCita.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAgendarCita);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(25, 32, 60, 17);
		contentPane.add(lblFecha);

		// campo de texto de la fecha
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(79, 30, 114, 21);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);

		lblHora = new JLabel("Hora");
		lblHora.setBounds(25, 75, 60, 17);
		contentPane.add(lblHora);

		textFieldHora = new JTextField();
		textFieldHora.setBounds(79, 73, 114, 21);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);

		// botón para agendar
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(28, 189, 117, 29);
		contentPane.add(btnAgendar);

		// listeners
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldFecha.getText().equals("") || textFieldHora.getText().equals("")) {
					muestraDialogoConMensaje("Los datos no deben estar vacíos");
				} else {
					// tomar la fecha
					DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fecha = LocalDate.parse(textFieldFecha.getText(), formatoFecha);

					// tomar la hora
					DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("h:mm a");
					LocalTime horaInicio = LocalTime.parse(textFieldHora.getText(), formatoHora);
					
					// String horaI = textFieldHora.getText();
					System.out.println(horaInicio);
					LocalTime horaFin = LocalTime.parse(textFieldHora.getText(), formatoHora);

					control.agregarCita(fecha, horaInicio, horaFin);
					// toma el dato de una lista de opciones desplegable
					// (String) comboBoxGrupo.getSelectedItem());
				}
			}
		});
	}

	public void muestra(ControlAgendarCita control) {
		this.control = control;
		setVisible(true);
	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
