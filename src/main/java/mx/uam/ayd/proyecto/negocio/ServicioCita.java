package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.CitaRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

@Service
/**
 * Servicio relacionado con las citas
 * 
 * @author axelhuerta
 *
 */
public class ServicioCita {
   @Autowired
   CitaRepository citaRepository; 

   public Cita agregarCita(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
      // Regla de negocio: No se permite agendar dos citas en un mismo horario

      Cita cita = citaRepository.findByFechaAndHoraInicioAndHoraFin(fecha, horaInicio, horaFin);

      if(cita != null) {
         throw new IllegalArgumentException("El horario no esta disponible");
      }

      // excepciones

      // mostrar datos en terminal
      System.out.println("Cita agregada. Fecha: " + fecha);

      cita = new Cita();
      cita.setFecha(fecha);
      cita.setHoraInicio(horaInicio);
      cita.setHoraFin(horaFin);

      citaRepository.save(cita);

      return cita;
   }
}
