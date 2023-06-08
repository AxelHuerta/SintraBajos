package mx.uam.ayd.proyecto.presentacion.EliminarCitas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


@Component
public class VentanaEliminarCitas extends JFrame {

	private JPanel contentPane;
	private JTable TablaDCitas;
    private ControlEliminarCita controlE;

	public VentanaEliminarCitas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 610);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Logo = new JPanel();
		Logo.setBounds(0, 0, 110, 97);
		Logo.setBackground(new Color(255,255,255));
		contentPane.add(Logo);
		Logo.setLayout(null);
		
		JLabel ILogo = new JLabel("");
		ILogo.setIcon(new ImageIcon(VentanaEliminarCitas.class.getResource("/img/Logo3.png")));
		ILogo.setBounds(10, 10, 90, 77);
		ILogo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.add(ILogo);
		
		JPanel Datos = new JPanel();
		Datos.setBounds(109, 0, 563, 97);
		Datos.setBackground(Color.LIGHT_GRAY);
		contentPane.add(Datos);
		Datos.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar Citas");
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		lblNewLabel.setBounds(216, 35, 133, 27);
		Datos.add(lblNewLabel);
		
		JLabel Ncita = new JLabel("Citas ");
		Ncita.setBounds(37, 107, 73, 30);
		Ncita.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		contentPane.add(Ncita);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(119, 107, 96, 30);
		contentPane.add(monthChooser);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 162, 594, 282);
		contentPane.add(scrollPane);
		TablaDCitas = new JTable();
		TablaDCitas.getTableHeader().setReorderingAllowed(false);
		DefaultTableModel model = new DefaultTableModel();
		TablaDCitas.setModel(model);
		 
		model.addColumn("Nombre");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		model.addColumn("Servicio");
		 
		scrollPane.setViewportView(TablaDCitas);
		
		JButton Eliminar = new JButton("Eliminar");
		Eliminar.setForeground(new Color(128, 255, 255));
		Eliminar.setBackground(Color.RED);
		Eliminar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		Eliminar.setBounds(508, 487, 123, 46);
		contentPane.add(Eliminar);
		
		JButton Regresar = new JButton("Regresar");
		Regresar.setForeground(new Color(128, 255, 255));
		Regresar.setBackground(Color.GRAY);
		Regresar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		Regresar.setBounds(37, 487, 123, 46);
		contentPane.add(Regresar);
        
        // LISTENERS 
        Regresar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                controlE.termina();
            }
        });
    }

    public void muestraE(ControlEliminarCita controlE){
        this.controlE = controlE;
		setVisible(true);
    }
}
