
package mx.uam.ayd.proyecto.presentacion.CitaAdministrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;
import com.toedter.calendar.JCalendar;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SuppressWarnings("serial")
@Component
public class VentanaCitaAdmin extends JFrame {

  private JPanel contentPane;
  private static final String FONT_TEXTO = "Roboto Light";
  private static final String FONT_CALENDAR = "Dubai Light";
  private JComboBox<String> comboBoxHoras;
  private DefaultComboBoxModel<String> comboBoxModelH = new DefaultComboBoxModel<>();	
  private DefaultComboBoxModel<String> comboBoxModelU = new DefaultComboBoxModel<>();	
  private JComboBox<String> comboBoxPaciente;
  private ControlCitaAdmin control;
  private List<Usuario> listaUsuario;

  /**
   * Create the frame.
   */
  public VentanaCitaAdmin() {
	  setTitle("Cita para Paciente");
		setResizable(false);
	    setLocationRelativeTo(null);// Centramos la ventana
	    setBounds(100, 100, 632, 730);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);  
		
		
		 JPanel panelRaiz = new JPanel();
		 panelRaiz.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
		    panelRaiz.setBackground(Color.WHITE);
		    panelRaiz.setBounds(0, 0, 615, 721);
		    contentPane.add(panelRaiz);
		    panelRaiz.setLayout(null);
		    
	     JPanel encabezado = new JPanel();
		    encabezado.setBackground(Color.LIGHT_GRAY);
		    encabezado.setBounds(0, 0, 617, 91);
		    panelRaiz.add(encabezado);
		    encabezado.setLayout(null);   
		    
		 JLabel logo = new JLabel("");
		    logo.setIcon(new ImageIcon(VentanaCitaAdmin.class.getResource("/img/Logo3.png")));
		    logo.setBounds(10, 11, 72, 73); 
		    encabezado.add(logo);
		    
		 JLabel titulo = new JLabel("Agendar Cita para Paciente");
		    titulo.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		    titulo.setBounds(183, 25, 262, 42);
		    encabezado.add(titulo);
		    
		 JCalendar calendar = new JCalendar();
		    calendar.getMonthChooser().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 14));
		    calendar.getMonthChooser().getSpinner().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 14));
		    calendar.getMonthChooser().getComboBox().setBackground(Color.WHITE);
		    calendar.getMonthChooser().getComboBox().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 15));
		    calendar.getYearChooser().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 14));
		    calendar.getMonthChooser().setBackground(Color.WHITE);
		    calendar.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		    calendar.getDayChooser().setBackground(Color.WHITE);
			calendar.setBounds(120, 120, 380, 220);
			panelRaiz.add(calendar);
			
		JLabel hora = new JLabel("Hora");
		hora.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			hora.setBounds(141, 357, 46, 17);
			panelRaiz.add(hora);

			comboBoxHoras = new JComboBox<>();
			comboBoxHoras.setFont(new Font(FONT_TEXTO, Font.PLAIN, 14));
			comboBoxHoras.setBounds(197, 358, 290, 17);
			panelRaiz.add(comboBoxHoras);
			
			DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("H:mm");			
			LocalTime[] lapzos = new LocalTime[8];

			// establece las horas que van a mostrarse
			int i = 8;
			for (LocalTime lap : lapzos) {
				LocalTime horario = LocalTime.parse(i + ":00", formatoHora);
				comboBoxModelH.addElement(horario.toString());
				i++;
			}
			
			comboBoxHoras.setModel(comboBoxModelH);
			((JLabel)comboBoxHoras.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT); //Alinea las horas a la derecha
			
			JLabel lpaciente = new JLabel("Nombre del Paciente");
			lpaciente.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			lpaciente.setBounds(33, 415, 162, 23);
			panelRaiz.add(lpaciente);
			
						
			JLabel lcorreo = new JLabel("Correo del Paciente");
			lcorreo.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			lcorreo.setBounds(33, 459, 155, 14);
			panelRaiz.add(lcorreo);
			
			JLabel ltipoCita = new JLabel("Tipo de Cita");
			ltipoCita.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			ltipoCita.setBounds(33, 509, 105, 14);
			panelRaiz.add(ltipoCita);
			
			JCheckBox chckbxGeneral = new JCheckBox("General");
			chckbxGeneral.setOpaque(false);
			chckbxGeneral.setForeground(Color.BLACK);
			chckbxGeneral.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			chckbxGeneral.setBounds(201, 505, 97, 23);
		    panelRaiz.add(chckbxGeneral);
			
			JLabel lhistorial = new JLabel("Historial Clinico");
			lhistorial.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			lhistorial.setBounds(33, 561, 120, 14);
			panelRaiz.add(lhistorial);
			
			JCheckBox chckbxUrgente = new JCheckBox("Urgente");
			chckbxUrgente.setOpaque(false);
			chckbxUrgente.setForeground(Color.BLACK);
			chckbxUrgente.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			chckbxUrgente.setBounds(360, 505, 97, 23);
			panelRaiz.add(chckbxUrgente);
			
			JButton bconsultar = new JButton("Consultar");
			bconsultar.setForeground(new Color(255, 255, 255));
			bconsultar.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			bconsultar.setBackground(new Color(30, 144, 255));
			bconsultar.setBounds(209, 558, 105, 23);
			panelRaiz.add(bconsultar);
			
			JButton bregistrar = new JButton("Registrar Cita");
			bregistrar.setForeground(new Color(255, 255, 255));
			bregistrar.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			bregistrar.setBackground(new Color(30, 144, 255));
			bregistrar.setBounds(33, 631, 198, 29);
			panelRaiz.add(bregistrar);
			
			JButton bcancelar = new JButton("Cancelar");
			bcancelar.setForeground(Color.WHITE);
			bcancelar.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			bcancelar.setBackground(new Color(255, 0, 0));
			bcancelar.setBounds(369, 631, 198, 29);
			panelRaiz.add(bcancelar);
			
			comboBoxPaciente = new JComboBox<>();
			comboBoxPaciente.setFont(new Font(FONT_TEXTO, Font.PLAIN, 14));
			comboBoxPaciente.setBounds(197, 417, 290, 17);
			panelRaiz.add(comboBoxPaciente);
			((JLabel)comboBoxPaciente.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT); //Alinea el nombre del paciente a la derecha 
			
			
			JComboBox<String> comboBoxCorreo = new JComboBox<>();
			comboBoxCorreo.setFont(new Font(FONT_TEXTO, Font.PLAIN, 14));
			comboBoxCorreo.setBounds(197, 457, 290, 17);
			panelRaiz.add(comboBoxCorreo);
			
			
			
			
			//LISTENERS
			
			bconsultar.addMouseListener(new MouseAdapter() {      // Listener de consultar
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			
			
			bregistrar.addMouseListener(new MouseAdapter() {          //Listener de Registrar
				@Override
				public void mouseClicked(MouseEvent e) {       
				}
			});
		   
			
			bcancelar.addMouseListener(new MouseAdapter() {         // Listener de Cancelar
				@Override
				public void mouseClicked(MouseEvent e) {   
					dispose();  // Metodo que cierra la ventana
				}
			});
			
  }

  public void muestra(ControlCitaAdmin control) {
	listaUsuario = null;
	comboBoxPaciente.removeAllItems();
    this.control = control;
    listaUsuario = control.listausuarios();
    for (Usuario Usuarios : listaUsuario) {
	comboBoxModelU.addElement(Usuarios.getNombre()+" "+Usuarios.getApellido()+ " "+Usuarios.getApellidomaterno()); 
    }
    comboBoxPaciente.setModel(comboBoxModelU);
    setVisible(true);
  }

}
