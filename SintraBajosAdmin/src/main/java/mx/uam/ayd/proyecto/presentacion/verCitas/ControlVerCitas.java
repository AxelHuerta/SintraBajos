package mx.uam.ayd.proyecto.presentacion.verCitas;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import mx.uam.ayd.proyecto.negocio.ServicioProximaCita;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

/**
 * 
 * Módulo de control para la historia de usuario AgendarCita
 * 
 * @author axelhuerta
 *
 */
@Component
public class ControlVerCitas {
   @Autowired
   private ServicioProximaCita proximaCita;

   @Autowired
   VentanaVerCitas ventana;

   /**
    * Inicia la historia de usuario
    * 
    */
   public void inicia() {
      ventana.muestra(this);
   }

   

	   public List<Cita> ProximasCitas(LocalDate fecha) {
		    try {
		        List<Cita> citas = proximaCita.obtenerCitasPorFecha(fecha);
		        	return citas;
		    } catch (Exception e) {
		        ventana.muestraDialogoConMensaje("Error al obtener las próximas citas: " + e.getMessage());
		        return null;
		    }
		}
	   

   /**
    * Termina la historia de usuario
    * 
    */
   public void termina() {
      ventana.setVisible(false);
   }
}
