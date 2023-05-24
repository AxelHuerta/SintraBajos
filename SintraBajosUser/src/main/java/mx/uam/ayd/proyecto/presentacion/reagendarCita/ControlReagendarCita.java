package mx.uam.ayd.proyecto.presentacion.reagendarCita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCita;
import mx.uam.ayd.proyecto.negocio.ServicioNotificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

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

  @Autowired
  ServicioNotificacion servicioNotificacion;

  /**
   * Inicia la historia de usuario
   * 
   */
  public void inicia(Usuario usuario) {
    ventana.muestra(this, usuario);
  }

  // listar citas
  public List<Cita> listarCitas() {
    return servicioCita.listarCitas();
  }

  // agregar citas
  public void agregarCita(LocalDate fecha, LocalTime hora, String servicio, String correo,String nombre) {
    try {
  	LocalDate fechaActual = LocalDate.now();

      if (fecha == null) {
        return;
      }
      if (fecha.isBefore(fechaActual)) {
          ventana.muestraDialogoConMensaje("Seleccione una fecha valida");
          return;
      }

      servicioCita.agregarCita(fecha, hora, servicio, correo,nombre);
      agregarNotificacionCita(fecha, hora, correo);
      ventana.muestraDialogoConMensaje("Cita agregada");
    } catch (Exception e) {
      ventana.muestraDialogoConMensaje("Error al agendar cita: " + e.getMessage());
    }
  }

  // agregar notificacion de la cita 
  public void agregarNotificacionCita(LocalDate fecha, LocalTime hora, String correo) {
    String message = "Se agregó tu cita para el " + fecha + " a las " + hora;
    servicioNotificacion.addNotificacion(message, correo);
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
  public List<Cita> ProximasCitas(String correo) {
    try {
      List<Cita> citas = servicioCita.obtenerCitasPorUsuario(correo);
      return citas;
    } catch (Exception e) {
      ventana.muestraDialogoConMensaje("Error al obtener las próximas citas: " + e.getMessage());
      return null;
    }
  }

  // Eliminar cita
  public void eliminarCita(LocalDate fecha, LocalTime hora, String correo) {
    try {
      servicioCita.eliminarCita(fecha, hora, correo);
      agregarNotificacionEliminacionCita(fecha, hora, correo);
    } catch (Exception e) {
      ventana.muestraDialogoConMensaje("Error al Eliminar Cita " + e.getMessage());
    }
  }
  // agregar notificacion de la cita 
  public void agregarNotificacionEliminacionCita(LocalDate fecha, LocalTime hora, String correo) {
    String message = "Se elimino tu cita para el " + fecha + " a las " + hora;
    servicioNotificacion.addNotificacion(message, correo);
  }

  /**
   * Termina la historia de usuario
   * 
   */
  public void termina() {
    ventana.setVisible(false);
  }
}
