package mx.uam.ayd.proyecto.negocio.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad de negocio Cita
 * 
 * @author axelhuerta
 *
 */
@Entity
@Data
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "hora")
    private LocalTime hora;
    @Column(name = "servicio")
    private String servicio;

}
