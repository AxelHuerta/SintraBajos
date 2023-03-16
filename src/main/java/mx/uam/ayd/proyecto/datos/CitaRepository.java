package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * Repositorio para citas
 * 
 * @author axelhuerta
 *
 */
public interface CitaRepository extends CrudRepository<Cita, Long> {
   // Encuentra una cita a partir de una fecha y hora
   public Cita findByFechaAndHora(LocalDate fecha, LocalTime hora);

   // Encuentra una cita a partir de una fecha
   public Cita findByFecha(LocalDate fecha);
}
