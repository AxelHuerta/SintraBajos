package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import mx.uam.ayd.proyecto.datos.CitaRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

/**
 * Servicio relacionado con las citas
 * 
 * @author axelhuerta
 *
 */
@Service
public class ServicioCita {
   @Autowired
   CitaRepository citaRepository;

   /**
    * 
    * Muestra las listas registradas en la terminal
    * 
    * @return Lista de citas
    */
   public List<Cita> listarCitas() {
      return (List<Cita>) citaRepository.findAll();
   }

   /**
    * 
    * Permite agregar una cita
    * 
    * @param fecha
    * @param hora
    * @param servicio
    * @return
    */
   public Cita agregarCita(LocalDate fecha, LocalTime hora, String servicio, Long idUsuario) {
      // Regla de negocio: No se permite agendar dos citas en un mismo horario

      Cita cita = citaRepository.findByFechaAndHora(fecha, hora);

      if (cita != null) {
         if (comprobarCitasDia(fecha) == true) {
            throw new IllegalArgumentException("Día lleno");
         } else {
            throw new IllegalArgumentException("El horario no esta disponible");
         }
      }

      cita = new Cita();
      ///////////////////////////////////////////////
      // falta conectar con el id del usaurio
      ///////////////////////////////////////////////
      cita.setIdUsuario((long) 123);
      cita.setFecha(fecha);
      cita.setHora(hora);
      cita.setServicio(servicio);

      citaRepository.save(cita);

      return cita;
   }

   /**
    * 
    * Comprueba si un dia ya no permite más citas
    * 
    * @param fecha
    * @return un boleano si todas las horas estan ocupadas
    */
   public boolean comprobarCitasDia(LocalDate fecha) {
      List<Cita> citas = new ArrayList<>();

      for (Cita cita : citaRepository.findAll()) {
         if (cita.getFecha().compareTo(fecha) == 0) {
            citas.add(cita);
         }
      }

      return citas.size() == 8 ? true : false;
   }

   /**
    * 
    * Permite Eliminar una cita
    * 
    * @param fecha
    * @param hora
    * @param idUsuario
    * @return
    */
   public void eliminarCita(LocalDate fecha, LocalTime hora, Long idUsuario) {
      // Buscar la cita correspondiente
      Cita cita = citaRepository.findByFechaAndHoraAndIdUsuario(fecha, hora, idUsuario);

      // Si se encontró la cita, eliminarla
      if (cita != null) {
         citaRepository.delete(cita);
      } else {
         throw new IllegalArgumentException("No se encontró la cita correspondiente");
      }
   }

   /**
    * 
    * Permite obtener una cita
    * 
    * @param idUsuario
    * @return
    */
   public List<Cita> obtenerCitasPorUsuario(Long idUsuario) {
      return citaRepository.findByIdUsuario(idUsuario);
   }
}