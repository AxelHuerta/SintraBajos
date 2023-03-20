package mx.uam.ayd.proyecto.presentacion.Notificacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioNotificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;

@Component
public class ControlNotificacion {

  @Autowired
  private ServicioNotificacion servicioNotificacion;

  @Autowired
  private VentanaNotificacion ventana;

  public void inicia() {
    ventana.muestra(this);
  }

  public Notificacion addNotificacion(String m, Long idUsuario) {
    try {
      Notificacion n = new Notificacion();
      n = servicioNotificacion.addNotificacion(m, idUsuario);
      return n;
    } catch (Exception ex) {
      ventana.muestraDialogoConMensaje("se agrego notificacion " + ex.getMessage());
    }
    return null;
  }

  public void deleteNotificacion(Long idUsuario) {
    try {
      ventana.muestraDialogoConMensaje("Notificaciones borradas");
      servicioNotificacion.deleteNotificacion(idUsuario);
    } catch (Exception ex) {
      ventana.muestraDialogoConMensaje("No fue posible borrar las notificaciones" + ex.getMessage());
    }
  }

  public List<Notificacion> recuperaNotificacion() {
    List<Notificacion> noti = new ArrayList<>();
    noti = servicioNotificacion.recuperaNotificacion();
    return noti;
  }
}