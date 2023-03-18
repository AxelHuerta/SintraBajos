package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * 
 * Repositorio para citas
 * 
 * @author axelhuerta
 *
 */
@Repository
public interface CitaRepository extends CrudRepository<Cita, Long> {
   // Encuentra una cita a partir de una fecha y hora
   public Cita findByFechaAndHora(LocalDate fecha, LocalTime hora);

   // Encuentra una cita a partir de una fecha
   public Cita findByFecha(LocalDate fecha);

   // Encuentra una cita a partir de fecha, hora, usuario
   public Cita findByFechaAndHoraAndIdUsuario(LocalDate fecha, LocalTime hora, Long idUsuario);

   // Encuentra las citas asociadas a un usuario

  public List<Cita> findByIdUsuario(Long idUsuario);
}
