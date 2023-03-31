package mx.uam.ayd.proyecto.presentacion.precios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
@Component
public class VentanaPrecios extends JFrame {

	private JPanel contentPane;
	
	private ControlPrecios control;
	private JTextField TCorreo;
	private JPasswordField TPass;

	
	public VentanaPrecios() {   // Ventana de Precios
		
		
		// ******* Listeners  ******

	}
	
	public void muestra(ControlPrecios control) {
		
		this.control = control;
		
		setVisible(true);
	}
}
