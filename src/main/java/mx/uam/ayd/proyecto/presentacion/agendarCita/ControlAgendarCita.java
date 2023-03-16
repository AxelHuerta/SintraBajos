package mx.uam.ayd.proyecto.presentacion.agendarCita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.ayd.proyecto.negocio.ServicioCita;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

/**
 * 
 * Módulo de control para la historia de usuario AgendarCita
 * 
 * @author axelhuerta
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
      ventana.muestra(this);
   }

   public List<Cita> listarCitas() {
      return servicioCita.listarCitas();
   }

   public void agregarCita(LocalDate fecha, LocalTime hora, String servicio) {
      try {
         servicioCita.agregarCita(fecha, hora, servicio);
         ventana.muestraDialogoConMensaje("Cita agregada");
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al agendar cita: " + e.getMessage());
      }
   }

   public void comprobarCitasDia(LocalDate fecha) {
      try {
         servicioCita.comprobarCitasDia(fecha);
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al consultar las citas del día: " + e.getMessage());
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
