package mx.uam.ayd.proyecto.datos;


import org.springframework.data.repository.CrudRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * Repositorio para usuarios
 * 
 * @author axelhuerta
 *
 */

public interface CitaRepository extends CrudRepository <Cita, Long> {
   // métodos de prueba 
   public Cita findByFechaAndHoraInicioAndHoraFin(LocalDate fecha, LocalTime horaIncio, LocalTime horaFin);
}
