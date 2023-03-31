package mx.uam.ayd.proyecto.presentacion.precios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.menuUsuario.ControlUsuario;



@Component
public class ControlPrecios {

	@Autowired
	private VentanaPrecios ventana;
	
	
	public void inicia() {

		ventana.muestra(this);
	}
}
