package mx.uam.ayd.proyecto.presentacion.reagendarCita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class ControlReagendarCita {
   @Autowired
   private ServicioCita servicioCita;

   @Autowired
   VentanaReagendarCita ventana;

   /**
    * Inicia la historia de usuario
    * 
    */
   public void inicia() {
      ventana.muestra(this);
   }

   // listar citas
   public List<Cita> listarCitas() {
      return servicioCita.listarCitas();
   }

   // agregar citas
   public void agregarCita(LocalDate fecha, LocalTime hora, String servicio, Long idUsuario) {
      try {
         if (fecha == null) {
            return;
         }
         servicioCita.agregarCita(fecha, hora, servicio, idUsuario);
         ventana.muestraDialogoConMensaje("Cita agregada");
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al agendar cita: " + e.getMessage());
      }
   }

   // Comprobar citas
   public void comprobarCitasDia(LocalDate fecha) {
      try {
         servicioCita.comprobarCitasDia(fecha);
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al consultar las citas del día: " + e.getMessage());
      }
   }

   // Proximas citas
   public List<Cita> ProximasCitas(Long idUsuario) {
      try {
         List<Cita> citas = servicioCita.obtenerCitasPorUsuario(idUsuario);
         return citas;
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al obtener las próximas citas: " + e.getMessage());
         return null;
      }
   }

   // Eliminar cita
   public void eliminarCita(LocalDate fecha, LocalTime hora, Long idUsuario) {
      try {
         servicioCita.eliminarCita(fecha, hora, idUsuario);
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al Eliminar Cita " + e.getMessage());
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