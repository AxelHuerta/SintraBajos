package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.Notificacion.ControlNotificacion;
import mx.uam.ayd.proyecto.presentacion.agendarCita.ControlAgendarCita;
import mx.uam.ayd.proyecto.presentacion.reagendarCita.ControlReagendarCita;

/**
 * Esta clase lleva el flujo de control de la ventana principal
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlPrincipal {

	@Autowired
	private ControlAgendarCita controlAgendarCita;

	@Autowired
	private ControlNotificacion controlNotificacion;

	@Autowired
	private ControlReagendarCita controlReagendarCita;

	@Autowired
	private VentanaPrincipal ventana;

	/**
	 * Inicia el flujo de control de la ventana principal
	 * 
	 */
	public void inicia() {

		ventana.muestra(this);
	}

	/**
	 * Método que arranca la historia de usuario "agendar citas"
	 * 
	 */
	public void agendarCitas() {
		controlAgendarCita.inicia();
	}

	/**
	 * Método que arranca la historia de usuario "agendar citas"
	 * 
	 */
	public void verNitificaciones() {
		controlNotificacion.inicia();
	}

	/**
	 * Método que arranca la historia de usuario "agendar citas"
	 * 
	 */
	public void reagendarCita() {
		controlReagendarCita.inicia();
	}
}
