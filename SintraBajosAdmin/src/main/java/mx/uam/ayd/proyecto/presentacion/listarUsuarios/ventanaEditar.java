package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class ventanaEditar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

    private ControlListarUsuarios controlE;
    private Usuario usuario;

	public ventanaEditar() {
		setTitle("Datos del Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDatosdelUsuario = new JLabel("Datos del Usuario");
		lblDatosdelUsuario.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDatosdelUsuario.setBounds(479, 30, 160, 29);
		lblDatosdelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDatosdelUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(350, 111, 98, 29);
		contentPane.add(lblNombre);

    textField = new JTextField();
		textField.setBounds(450, 111, 280, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidoP = new JLabel("Apellido P:");
		lblApellidoP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblApellidoP.setBounds(350, 150, 98, 29);
		contentPane.add(lblApellidoP);

    textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(450, 150, 280, 26);
		contentPane.add(textField_1);

    JLabel lblApellido = new JLabel("Apellido M:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblApellido.setBounds(350, 189, 98, 29);
		contentPane.add(lblApellido);

    textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(450, 189, 280, 26);
		contentPane.add(textField_2);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTelfono.setBounds(350, 228, 98, 29);
		contentPane.add(lblTelfono);

    textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(450, 228, 280, 26);
		contentPane.add(textField_3);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCorreo.setBounds(350, 267, 98, 29);
		contentPane.add(lblCorreo);

    textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(450, 267, 280, 26);
		contentPane.add(textField_4);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDireccin.setBounds(350, 306, 98, 29);
		contentPane.add(lblDireccin);

    textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(450, 298, 280, 50);
		contentPane.add(textField_5);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se guardo correctamente");
			}
		});
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 15));
		btnGuardar.setBounds(601, 444, 143, 38);
		contentPane.add(btnGuardar);
		
	}
	
    public void muestraE(ControlListarUsuarios control, Usuario usuario) {
        this.controlE = control;
        this.usuario = usuario;

        textField.setText(usuario.getNombre());
        textField_1.setText(usuario.getApellido());
        textField_2.setText(usuario.getApellidomaterno());
        textField_3.setText(String.valueOf(usuario.getTelefono()));
        textField_4.setText(usuario.getCorreo());
        textField_5.setText(usuario.getDomicilio());
        setVisible(true);
    }

    public void cierra() { 
        setVisible(false);
    }
    
    public void muestraMensaje() {
        JOptionPane.showMessageDialog(null, "La informacion fue actualizada correctamente.");
        cierra();
    }
}