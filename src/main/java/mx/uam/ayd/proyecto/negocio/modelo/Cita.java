package mx.uam.ayd.proyecto.negocio.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Cita {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;
    private Long idUsuario;
    private LocalDate fecha; // (year, month, day)
    private LocalTime hora;
    private String servicio;


}
