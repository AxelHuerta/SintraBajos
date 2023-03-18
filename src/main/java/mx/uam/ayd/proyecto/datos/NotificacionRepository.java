package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;

public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {

  public Notificacion findByIdUsuario(long idUsuario);

  public Notificacion deleteAllById(Long idUsuario);
}