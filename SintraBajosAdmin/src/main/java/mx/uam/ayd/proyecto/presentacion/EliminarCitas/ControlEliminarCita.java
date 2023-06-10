package mx.uam.ayd.proyecto.presentacion.EliminarCitas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProximaCita;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;



@Component
public class ControlEliminarCita {

    @Autowired
    private VentanaEliminarCitas ventana;

    @Autowired
    private ServicioProximaCita servicioProximaCita;


    //inicia programa
    public void inicia(){
        ventana.muestraE(this);
    }

    public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {
        System.out.println(servicioProximaCita.obtenerCitasPorFecha(fecha));
        return servicioProximaCita.obtenerCitasPorFecha(fecha);
    }

    //termina programa
    public void termina(){
        ventana.setVisible(false);
    } 

    public void eliminarCita(String nombre, LocalDate fecha, LocalTime hora, String servicio){
        servicioProximaCita.eliminarCita(nombre, fecha, hora, servicio);
    }
}
