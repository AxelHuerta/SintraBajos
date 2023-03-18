package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.NotificacionRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;

@Service
public class ServicioNotificacion {
  @Autowired
  private NotificacionRepository notificacionRepository;

  public Notificacion addNotificacion(String message, long idUsuario) {
    Notificacion notificacion = notificacionRepository.findByIdUsuario(idUsuario);

    notificacion = new Notificacion();
    notificacion.setIdUsuario(idUsuario);
    notificacion.setMessage(message);

    notificacionRepository.save(notificacion);

    return notificacion;
  }

  public Notificacion deleteNotificacion(long idUsuario) {
    Notificacion notificacion = notificacionRepository.deleteAllById(idUsuario);
    return notificacion;
  }

  public List<Notificacion> recuperaNotificacion() {
    List<Notificacion> noti = new ArrayList<>();
    for (Notificacion notifi : notificacionRepository.findAll()) {
      noti.add(notifi);
    }
    return noti;
  }
}