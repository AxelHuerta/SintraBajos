package mx.uam.ayd.proyecto.presentacion.agendarCita;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCita;

/**
 * 
 * Módulo de control para la historia de usuario AgendarCita
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlAgendarCita {
   @Autowired
   private ServicioCita servicioCita;

   @Autowired
   VentanaAgendarCita ventana;

   /**
    * Inicia la historia de usuario
    * 
    */
   public void inicia() {
      System.out.println("Se abrió la vetana de las citas !!!");

      ventana.muestra(this);
   }

   public void agregarCita(LocalDate fecha, LocalTime []horario, String servicio) {
      try {
         servicioCita.agregarCita(fecha, horario, servicio);
         ventana.muestraDialogoConMensaje("Cita agregada");
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al agendar cita: " + e.getMessage());
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
